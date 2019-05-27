package com.epam.dao.admin;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

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
	
	public MentorBean viewMentor(String id) throws SQLException
	{
		
		MentorBean mentor=new MentorBean();
		String sql="select * from Mentor_info where Email_Id=?";
		ResultSet rs=null;
		try(Connection con = DBManager.getConnection();PreparedStatement  ps = con.prepareStatement(sql))
		{
			ps.setString(1,id);
			rs=ps.executeQuery();
			while(rs.next()) {
			mentor.setName(rs.getString(2));
			mentor.setEmail(rs.getString(3));
			mentor.setMaxNoOfMentees(rs.getInt(6));
			mentor.setTechnologyStream(rs.getString(7));
			mentor.setStatus(rs.getString(8));
			mentor.setMentorStartDate(rs.getDate(4));
			mentor.setMentorEndDate(rs.getDate(5));
			
			return mentor;
			
			}
						
		}
		catch(Exception e)
		{
			
			LOGGER.error(e.getMessage());
		}
		finally {
			try {
	            if (rs != null) {
	                rs.close();
	            }
	        } catch (SQLException e3) {
	            // Can't do nothing
	        }
		}
		
		return mentor;
		
	}	
	
	
	public int updateMentor(MentorBean mentor) throws SQLException
	{
		
		int result=0;
		String sql="update Mentor_Info set Mentor_Name=?,Mentorship_Start_Date=?,Mentorship_End_Date=?,Max_No_Mentees=?,Technology_Stream=?,Status=? where Email_Id=?";
		try(Connection con = DBManager.getConnection();PreparedStatement  ps = con.prepareStatement(sql))
		{
			
			
			
			ps.setString(1, mentor.getName());
			ps.setDate(2, new java.sql.Date((mentor.getMentorStartDate().getTime())));
			ps.setDate(3, new java.sql.Date((mentor.getMentorEndDate().getTime())));
			ps.setInt(4, mentor.getMaxNoOfMentees());
			ps.setString(5, mentor.getTechnologyStream());
			ps.setString(6, mentor.getStatus());
			ps.setString(7,mentor.getEmail());
		
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

	
	
	
	

