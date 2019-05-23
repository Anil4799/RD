package com.epam.services.admin;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.epam.dao.admin.Mentor;

public class AdminMentorInfoServiceImpl implements AdminMentorInfoService {
	private static final Logger LOGGER = Logger.getLogger(AdminMentorInfoServiceImpl.class);
    
	@Override
	public List<Mentor> getAllMentorDetails(Connection con) {
		
		List<Mentor> mentorList = new ArrayList<>();
		String sql="call mentor();";
		try(CallableStatement  cs= con.prepareCall(sql);ResultSet rs=cs.executeQuery(sql) )
		{
			if(rs!=null)
			{
			while(rs.next())
			{   
				Mentor mentor=new Mentor();
				mentor.setEmailid(rs.getString("Email_Id"));

				mentor.setMentorname(rs.getString("Mentor_Name"));
				mentor.setMentorshipstartdate(rs.getString("mentorship_start_date"));
				mentor.setMentorshipenddate(rs.getString("mentorship_end_date"));
				mentor.setMaxnoofmentees(rs.getString("max_no_mentees"));
				mentor.setTechnologystream(rs.getString("technology_stream"));
				mentor.setMentorStatus(rs.getString("status"));
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
