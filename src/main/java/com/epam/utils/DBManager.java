/**
 * 
 */
package com.epam.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Durga_Adimulam
 *
 */
public class DBManager {

	public static Connection getConnection() {
		Connection connection = null;
		
		try
        {
			Class.forName(ApplicationProperties.getPropertyValue("db.driver"));
            connection = DriverManager.getConnection(ApplicationProperties.getPropertyValue("db.host"), 
            		ApplicationProperties.getPropertyValue("db.user"), 
            		ApplicationProperties.getPropertyValue("db.password"));
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		return connection;
	}
}