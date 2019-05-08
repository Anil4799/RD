package com.epam.services.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.epam.utils.DBManager;

public class GetMenuItemsServiceImpl implements GetMenuItemsService {
	ArrayList<Menu> menu;
	@Override
	public ArrayList<Menu> getMenuItems(int id) {
		// TODO Auto-generated method stub
		menu = new ArrayList<Menu>();
		Connection con = DBManager.getConnection();
		Statement stmt;
		ResultSet rs;
		try {
			stmt = con.createStatement();
			rs= stmt.executeQuery("select * from menu where menuid in (select menuid from rolewithmenu where roleid="+id+")"); 
	        while(rs.next()) {
	        	menu.add(new Menu(rs.getString(2),rs.getString(3)));
	        }
	        
		} catch (SQLException e) { // TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return menu;
	}

}
