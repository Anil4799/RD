package com.epam.services.admin;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dao.admin.AdminMentor;


public class AdminMentorInfoServiceImpl implements AdminMentorInfoService {
	private static final Logger LOGGER = Logger.getLogger(AdminMentorInfoServiceImpl.class);

	@Override
	public List<AdminMentor> getAllMentorDetails(Connection con) {
		
		List<AdminMentor> mentorList = new ArrayList<AdminMentor>();
		try
		{

			/* String sql="SELECT * FROM Mentor_Info ORDER BY\r\n" + 
					" email_id DESC\r\n" + 
					"LIMIT 10;";
					*/
			String sql = "call mentor();";
			CallableStatement cs= con.prepareCall(sql);
			ResultSet rs=cs.executeQuery(sql);
			if(rs!=null)
			{
			while(rs.next())
			{   
				AdminMentor mentor=new AdminMentor();
				mentor.setEmail_id("email_id");
				mentor.setMentor_name(rs.getString("name"));
				mentor.setMentorship_start_date("mentorship_start_date");
				mentor.setMentorship_end_date("mentorship_end_date");
				mentor.setMax_no_of_mentees("max_no_of_mentees");
				mentor.setTechnology_stream(rs.getString("technology_stream"));
				mentor.setStatus(rs.getString("status"));
				mentorList.add(mentor);
			}
			
			}
					
		}
		catch(Exception e)
		{
			LOGGER.error("Exception occured in MentorInfo = {}", e);
			
		}
		
		return mentorList;
	}

}
