package com.epam.services.mentor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.epam.dao.mentor.MentorStudent;

public class MentorStudentInfoServiceImpl implements MentorStudentInfoService {

	@Override
	public List<MentorStudent> mentorStudentDetails(Connection con, String mentorEmailId) {
		
		List<MentorStudent> studentList = new ArrayList<>();
		
		//String sql = "call mentorStudent('"+mentorEmailId+"');";
		String sql = "call mentorStudent(?);";
		try(CallableStatement cs= con.prepareCall(sql);)
		{
			cs.setString(1, mentorEmailId);
			try(ResultSet rs = cs.executeQuery();)
			{
				while(rs.next())
				{
					MentorStudent student=new MentorStudent();
					String emailId = rs.getString("email_id");
					String firstName=rs.getString("first_name");
					String lastName=rs.getString("last_name");
					String name=firstName+" "+lastName;
					student.setName(name);
					student.setBatch(rs.getString("batch_id"));
					student.setCoreSkill(rs.getString("core_skill"));
					student.setStatus(rs.getString("status"));	
					student.setEmail(emailId);
					studentList.add(student);
				}
			}
			
		}
		catch(Exception e)
		{
			studentList=null;
		}
		
	return studentList;
	}
}
