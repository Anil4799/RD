package com.epam.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	
	public DatabaseConnection(){
		super();
	}
	
	public static Connection getConnection() {
		Properties file = new Properties(); 
		String databaseUserName = "", databasePassword = "", dbHost = "";
    	try {
                    
                    File file2 = new File("C://Users/Nayamtulla_Khan/eclipse-workspace/RDPortal/src/Config.properties");
                    FileInputStream fis = new FileInputStream(file2);
                    
                 // load a properties file
                    file.load(fis);

                    // get the property value and print it out
                    dbHost = file.getProperty("dbHost");
                     databaseUserName = file.getProperty("databaseUserName");
                    databasePassword = file.getProperty("databasePassword");
                    System.out.println("databaseUserName = "+databaseUserName);
                    System.out.println("\n databasePassword = "+databasePassword);
                    
    	 } catch (IOException ex) {
             ex.printStackTrace();
    	 }
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(dbHost, databaseUserName, databasePassword);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
