package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.epam.dao.admin.AdminMentor;
import com.epam.services.admin.AdminMentorInfoServiceImpl;
import com.epam.utils.DBManager;

import jdk.nashorn.internal.ir.annotations.Ignore;

class MentorInfoTest {
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
	@Ignore
	void test2()
	{   lsactual =mentor.getAllMentorDetails(DBManager.getConnection());
		AdminMentor m= lsactual.get(1);	
		lsactual =mentor.getAllMentorDetails(DBManager.getConnection());
		String email_id=null;
		String mentor_name=null;
		String mentorship_start_date=null;
		String 	mentorship_end_date=null;
		String max_no_of_mentees=null;
		String technology_stream=null;
		String status=null;
//		email_id=m.getEmailid();
//		mentor_name=m.getMentorName();
//		mentorship_start_date=m.getMentorshipStartDate();
//		mentorship_end_date=m.getMentorShipEnddate();
//		max_no_of_mentees=m.getMaxnoOfMentees();
//		technology_stream=m.getTechnologyStream();
//		status=m.getStatus();
//		assertNotNull(email_id);
//		assertNotNull(mentor_name);
//		assertNotNull(mentorship_start_date);
//		assertNotNull(mentorship_end_date);
//		assertNotNull(max_no_of_mentees);
//		assertNotNull(technology_stream);
//		assertNotNull(status);
	}

}
