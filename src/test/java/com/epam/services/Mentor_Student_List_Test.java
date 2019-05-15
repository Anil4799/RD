package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.epam.dao.mentor.MentorStudent;
import com.epam.services.mentor.MentorStudentInfoServiceImpl;
import com.epam.utils.DBManager;

class Mentor_Student_List_Test {
	static DBManager db;
	static MentorStudentInfoServiceImpl mentorstudent;
	static Connection con=null;
	List<MentorStudent> lsactual=null;
	@BeforeAll
	static void  initializer()
	{
		mentorstudent=new MentorStudentInfoServiceImpl();
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
		
	 lsactual =mentorstudent.MentorStudentDetails(DBManager.getConnection());
		assertEquals(expected, lsactual.size());
			
	}
	@Test
	void test2() throws Exception
	{   lsactual =mentorstudent.MentorStudentDetails(DBManager.getConnection());
	MentorStudent s= lsactual.get(1);
	String name=null;
	String batch=null;
	String coreSkill=null;
	
	String status=null;
		name=s.getName();
		batch=s.getBatch();
		coreSkill=s.getcoreSkill();
		status=s.getStatus();
		assertNotNull(name);
		assertNotNull(batch);
		assertNotNull(coreSkill);
		
		assertNotNull(status);
		
		
	}

}
