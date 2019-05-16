package com.epam.dao.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.epam.services.login.Menu;
import com.epam.utils.DBManager;

public class LoginDAOImp implements LoginDAO {
	public Connection con;
	Statement stmt;
	ResultSet rs;
	public LoginDAOImp() {
		// TODO Auto-generated constructor stub
		con = DBManager.getConnection();
	}
	@Override
	public int login(String email, String password) {
		// TODO Auto-generated method stub
		try {
			stmt = con.createStatement();
			rs= stmt.executeQuery("select * from userinfo where email = '"+email+"' and password ='"+password+"'"); 
	        if(rs.next()) {
	        	return rs.getInt(3);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public ArrayList<Menu> getMenuItems(int roleid) {
		// TODO Auto-generated method stub
		ArrayList<Menu> menu = new ArrayList<Menu>();
		try {
			stmt = con.createStatement();
			rs= stmt.executeQuery("select * from menu where menuid in (select menuid from rolewithmenu where roleid="+roleid+")"); 
	        while(rs.next()) {
	        	menu.add(new Menu(rs.getString(2),rs.getString(3)));
	        }
	        
		} catch (SQLException e) { // TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return menu;
	}
	
	

}
