package com.epam.services.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.epam.dao.LoginDAOImp;
import com.epam.utils.DBManager;

public class LoginServiceImp implements LoginService {

	
	@Override
	public int login(String email, String password) {
		// TODO Auto-generated method stub
		/*Connection con = DBManager.getConnection();
		Statement stmt;
		ResultSet rs;
		try {
			stmt = con.createStatement();
			rs= stmt.executeQuery("select * from userinfo where email = '"+email+"' and password ='"+password+"'"); 
	        if(rs.next()) {
	        	return rs.getInt(3);
	        }
		} catch (SQLException e) { // TODO Auto-generated catch block 
			e.printStackTrace();
		}*/
		return new LoginDAOImp().login(email,password);
	}
}
