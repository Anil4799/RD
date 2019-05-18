package com.epam.services.mentor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dao.mentor.MentorStudent;

public class MentorStudentInfoServiceImpl implements MentorStudentInfoService {
	private static final Logger LOGGER = Logger.getLogger(MentorStudentInfoServiceImpl.class);
	@Override
	public List<MentorStudent> mentorStudentDetails(Connection con, String mentorEmailId) {
		 
		List<MentorStudent> studentList = new ArrayList<>();
		String sql = "call mentorStudent('test_mentor1@epam.com');";
		try(CallableStatement cs= con.prepareCall(sql);)
		{
			try(ResultSet rs = cs.executeQuery();)
			{
				while(rs.next())
				{
					MentorStudent student=new MentorStudent();
					String firstName=rs.getString("first_name");
					String lastName=rs.getString("last_name");
					String name=firstName+" "+lastName;
					student.setName(name);
					student.setBatch(rs.getString("batch_id"));
					student.setCoreSkill(rs.getString("core_skill"));
					student.setStatus(rs.getString("status"));	
					studentList.add(student);
				}
			}

		}
		catch(Exception e)
		{
			studentList=null;
			LOGGER.debug(e.getMessage());
		}
		
	return studentList;
	}
}
