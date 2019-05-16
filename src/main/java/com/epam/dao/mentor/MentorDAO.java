package com.epam.dao.mentor;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.epam.mentor.bean.MentorBean;
import com.epam.utils.DBManager;

public class MentorDAO {

	public int createMentor(MentorBean mentor) throws SQLException 
	{
		PreparedStatement ps=null;
		
		
		try {
		Connection con = DBManager.getConnection();
	
		 ps = con.prepareStatement("insert into Mentor_info (email_id, name, mentorship_start_date, mentorship_end_date, max_no_of_mentees, technology_stream, status) values(?,?,?,?,?,?,?)");
		
		ps.setString(1,mentor.getEmail());
		ps.setString(2, mentor.getName());
		ps.setDate(3, new java.sql.Date((mentor.getMentorStartDate().getTime())));
		ps.setDate(4, new java.sql.Date((mentor.getMentorEndDate().getTime())));
		ps.setInt(5, mentor.getMaxNoOfMentees());
		ps.setString(6, mentor.getTechnologyStream());
		ps.setString(7, mentor.getStatus());
	
		return ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			ps.close();
		}
		return 0;
	}
	
	
	
	
}
