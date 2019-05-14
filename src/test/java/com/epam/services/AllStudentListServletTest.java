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

import com.epam.dao.Student;
import com.epam.utils.DBManager;

class AllStudentListServletTest {
	static DBManager db;
	static StudentInfoServiceImpl student;
	static Connection con=null;
	List<Student> lsactual=null;
	@BeforeAll
	static void  initializer()
	{
		student=new StudentInfoServiceImpl();
		db=new DBManager();
	}
     
	@Test
	 void test1() throws Exception {
		
	    con=DBManager.getConnection();
		Statement stmt=con.createStatement();
		String sql="select * from student_personal_info, student__additional_info where student_personal_info.email_id = student__additional_info.email_id";
		ResultSet rs=stmt.executeQuery(sql);
	    int expected=0;
	    while(rs.next())
	    {
	    	expected++;
	    }
		
	 lsactual =student.getAllStudentDetails(DBManager.getConnection());
		assertEquals(expected, lsactual.size());
			
	}
	

}
