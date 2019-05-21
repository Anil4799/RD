package com.epam.dao.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.services.login.Menu;
import com.epam.utils.DBManager;

public class LoginDAOImp implements LoginDAO {
	private Connection connection;
	private ResultSet resultSet;
	private PreparedStatement preparedStatements;
	private String sql;
	private static final Logger LOGGER = Logger.getLogger(LoginDAOImp.class);
	public LoginDAOImp() {
		connection = DBManager.getConnection();
	}
	@Override
	public int login(String email, String password) {
		sql = "select * from userinfo where email = ? and password = ?;";
		try {
			preparedStatements = connection.prepareStatement(sql);
			preparedStatements.setString(1, email);
			preparedStatements.setString(2, password);
			resultSet = preparedStatements.executeQuery();
	        if(resultSet.next()) {
	        	return resultSet.getInt(3);
	        }
		} catch (SQLException e) {
			LOGGER.info("Exception..............." +e);
		}
		return 0;
	}
	@Override
	public List<Menu> getMenuItems(int roleId) {
		List<Menu> menu = new ArrayList<>();
		sql = "select * from menu where menuid in (select menuid from rolewithmenu where roleid = ?);";
		try {
			preparedStatements = connection.prepareStatement(sql);
			preparedStatements.setInt(1, roleId);
			resultSet= preparedStatements.executeQuery();
	        while(resultSet.next()) {
	        	menu.add(new Menu(resultSet.getString(2),resultSet.getString(3)));
	        }
	        
		} catch (SQLException e) {
			LOGGER.info("Exception..............." +e);
		}
		return menu;
	}
	
	

}
