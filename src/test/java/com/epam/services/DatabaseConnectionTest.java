package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import hthurow.tomcatjndi.TomcatJNDI;

class DatabaseConnectionTest {

	@Test
	void test() {
		DataSource ds = null;
		try {
			TomcatJNDI tomcatJNDI = new TomcatJNDI();
			tomcatJNDI.processContextXml(new File("src/main/resources/context.xml"));
			tomcatJNDI.start();
			
			ds = (DataSource) InitialContext.doLookup("java:comp/env/jdbc/abc");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(ds);
		
		
		
		
		
		
		
	}

}
