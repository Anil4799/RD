package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.epam.dao.admin.AdminMentor;
import com.epam.services.admin.AdminMentorInfoServiceImpl;
import com.epam.utils.DBManager;

import jdk.nashorn.internal.ir.annotations.Ignore;

class AllMentorListTest {
	static DBManager db;
	static AdminMentorInfoServiceImpl mentor;
	static Connection con=null;
	List<AdminMentor> lsactual=null;
	@BeforeAll
	static void  initializer()
	{
		mentor=new AdminMentorInfoServiceImpl();
		db=new DBManager();
	}
     
	@Ignore
	 void test1() throws Exception {
		
	    con=DBManager.getConnection();
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM Mentor_Info";
		ResultSet rs=stmt.executeQuery(sql);
	    int expected=0;
	    while(rs.next())
	    {
	    	expected++;
	    }
		
	 lsactual =mentor.getAllMentorDetails(DBManager.getConnection());
		assertEquals(expected, lsactual.size());
			
	}
	
	

}
