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

import com.epam.dao.Mentor;
import com.epam.utils.DBManager;

class AllMentorListServletTest {
	static DBManager db;
	static MentorInfoServiceImpl mentor;
	static Connection con=null;
	List<Mentor> lsactual=null;
	@BeforeAll
	static void  initializer()
	{
		mentor=new MentorInfoServiceImpl();
		db=new DBManager();
	}
     
	@Test
	 void test1() throws SQLException {
		
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
	@Test
	void test2()
	{   lsactual =mentor.getAllMentorDetails(DBManager.getConnection());
		Mentor m= lsactual.get(1);
		String email_id=null;
		String mentor_name=null;
		String mentorship_start_date=null;
		String 	mentorship_end_date=null;
		String max_no_of_mentees=null;
		String technology_stream=null;
		String status=null;
		email_id=m.getEmail_id();
		mentor_name=m.getMentor_name();
		mentorship_start_date=m.getMentorship_start_date();
		mentorship_end_date=m.getMentorship_end_date();
		max_no_of_mentees=m.getMax_no_of_mentees();
		technology_stream=m.getTechnology_stream();
		status=m.getStatus();
		assertNotNull(email_id);
		assertNotNull(mentor_name);
		assertNotNull(mentorship_start_date);
		assertNotNull(mentorship_end_date);
		assertNotNull(max_no_of_mentees);
		assertNotNull(technology_stream);
		assertNotNull(status);
		
	}
	

}
