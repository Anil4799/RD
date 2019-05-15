package com.epam.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class DBManagerTest {
    
	static DBManager db=null;
	Connection con=null;
	@BeforeAll
	static void  initializer()
	{
		
		db=new DBManager();
	}
	@Test
	void test() throws Exception {
		Connection conlocal=DBManager.getConnection();
		assertNotEquals(con, conlocal);
	}

}
