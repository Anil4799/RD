/**
 * 
 */
package com.epam.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;


/**
 * @author Durga_Adimulam
 *
 */
public class DBManager {
	private static final Logger LOGGER = Logger.getLogger( DBManager.class);
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
            LOGGER.error("Exception occured in MentorInfo = {}", e);
        }
		
		return connection;
	}
}
