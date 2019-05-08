/**
 * 
 */
package com.epam.utils;

import java.util.ResourceBundle;

/**
 * @author Durga_Adimulam
 *
 */
public class ApplicationProperties {

	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
         
    public static String getPropertyValue(String key){
    	return resourceBundle.getString(key);
    }
    
}
