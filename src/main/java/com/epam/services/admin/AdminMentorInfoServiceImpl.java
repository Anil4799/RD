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
		String sql="call mentor();";
		try(CallableStatement  cs= con.prepareCall(sql);ResultSet rs=cs.executeQuery(sql) )
		{
			if(rs!=null)
			{
			while(rs.next())
			{   
				AdminMentor mentor=new AdminMentor();
				mentor.setEmailid("email_id");
				mentor.setMentorName(rs.getString("mentor_name"));
				mentor.setMentorshipStartDate("mentorship_start_date");
				mentor.setMentorShipEndDate("mentorship_end_date");
				mentor.setMaxnoOfMentees("max_no_of_mentees");
				mentor.setTechnologyStream(rs.getString("technology_stream"));
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
