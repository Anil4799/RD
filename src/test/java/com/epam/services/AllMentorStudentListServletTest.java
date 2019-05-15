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

import com.epam.dao.mentor.MentorStudent;
import com.epam.services.mentor.MentorStudentInfoServiceImpl;
import com.epam.utils.DBManager;

class AllMentorStudentListServletTest {
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
	 void test1() throws SQLException {
		
	    con=DBManager.getConnection();
		Statement stmt=con.createStatement();
		String sql="select student_personal_info.first_name,student_personal_info.last_name ,student__additional_info.batch_id ,student__additional_info.core_skill,student__additional_info.status, mentor_info.email_id from student_personal_info, student__additional_info ,mentor_info where mentor_info.email_id = 'ab@gmail.com' ORDER BY batch_id DESC LIMIT 10;";
		ResultSet rs=stmt.executeQuery(sql);
	    int expected=0;
	    while(rs.next())
	    {
	    	expected++;
	    }
		
	 lsactual =mentorstudent.mentorStudentDetails(DBManager.getConnection(),  "ab@gmail.com");
		assertEquals(expected, lsactual.size());
			
	}
	@Test
	void test2()
	{   lsactual =mentorstudent.mentorStudentDetails(DBManager.getConnection(), "ab@gmail.com");
	MentorStudent s= lsactual.get(1);
	String name=null;
	String batch=null;
	String coreSkill=null;
	
	String status=null;
		name=s.getName();
		batch=s.getBatch();
		coreSkill=s.getCoreSkill();
		status=s.getStatus();
		assertNotNull(name);
		assertNotNull(batch);
		assertNotNull(coreSkill);
		assertNotNull(status);
		
		
	}
	

}
