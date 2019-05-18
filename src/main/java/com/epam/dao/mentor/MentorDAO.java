package com.epam.dao.mentor;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.epam.mentor.bean.MentorBean;
import com.epam.utils.DBManager;

public class MentorDAO {
	private static final Logger LOGGER = Logger.getLogger( MentorDAO.class);
	public int createMentor(MentorBean mentor) throws SQLException
	{
		
		int result=0;
		String sql="insert into Mentor_info (Email_Id, Mentor_name, mentorship_start_date, mentorship_end_date, max_no_mentees, technology_stream, status) values(?,?,?,?,?,?,?)";
		try(Connection con = DBManager.getConnection();PreparedStatement  ps = con.prepareStatement(sql))
		{

			ps.setString(1,mentor.getEmail());
			ps.setString(2, mentor.getName());
			ps.setDate(3, new java.sql.Date((mentor.getMentorStartDate().getTime())));
			ps.setDate(4, new java.sql.Date((mentor.getMentorEndDate().getTime())));
			ps.setInt(5, mentor.getMaxNoOfMentees());
			ps.setString(6, mentor.getTechnologyStream());
			ps.setString(7, mentor.getStatus());
			result=ps.executeUpdate();
			return result;
			
						
		}
		catch(Exception e)
		{
			
			LOGGER.error(e.getMessage());
		}
		return result;
		
	}	
		
	}

	
	
	
	

