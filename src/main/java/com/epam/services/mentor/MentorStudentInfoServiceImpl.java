package com.epam.services.mentor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dao.admin.StudentBean;
import com.epam.dao.mentor.MentorStudent;

public class MentorStudentInfoServiceImpl implements MentorStudentInfoService {
	private static final Logger LOGGER = Logger.getLogger(MentorStudentInfoServiceImpl.class);
	@Override
	public List<MentorStudent> mentorStudentDetails(Connection con, String mentorEmailId) {
		 
		List<MentorStudent> studentList = new ArrayList<>();
		String sql = "call mentorStudent('"+mentorEmailId+"');";
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
					student.setMentorStudentEmailId(rs.getString("email_id"));
					student.setMentorStudentName(name);
					student.setMentorStudentBatch(rs.getString("batch_id"));
					student.setMentorStudentCoreSkill(rs.getString("core_skill"));
					student.setMentorStudentStatus(rs.getString("status"));	
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
	@Override
	public List<MentorStudent> getAllSearchStudentDetails(Connection con,String mentorEmailId, String firstNamedb, String lastNamedb,
			String batchIDdb) {
		
		List<MentorStudent> studentList = new ArrayList<>();
		String sql="call search_mentor_student('"+mentorEmailId+"','"+firstNamedb+"','"+lastNamedb+"','"+batchIDdb+"');";
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
					student.setMentorStudentName(name);
					student.setMentorStudentBatch(rs.getString("batch_id"));
					student.setMentorStudentCoreSkill(rs.getString("core_skill"));
					student.setMentorStudentStatus(rs.getString("status"));
					student.setMentorStudentEmailId(rs.getString("email_id"));
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
	
	public List<StudentBean> mentorViewStudentDetails(Connection con, String emailId) {
		
		List<StudentBean> studentList = new ArrayList<>();
		String sql = "call viewStudent('"+emailId+"');";
		try(CallableStatement cs= con.prepareCall(sql);)
		{
			try(ResultSet rs = cs.executeQuery();)
			{
				while(rs.next())
				{
					StudentBean student=new StudentBean();
					student.setFirstName(rs.getString("first_name"));
					student.setLastName(rs.getString("last_name"));
					student.setDateOfBirth(rs.getString("date_of_birth")); 
					student.setEmail(rs.getString("email_id"));
					student.setGender(rs.getString("gender"));
					student.setContactNumber(rs.getLong("contact"));
					student.setPersonalLocation(rs.getString("location"));
					student.setCollegeName(rs.getString("college_name"));
					student.setCollegeLocation(rs.getString("college_loc"));
					student.setGraduation(rs.getString("graduation"));
					student.setGraduationSpeciality(rs.getString("graduation_stream"));
					student.setYearOfPassedOut(rs.getInt("Passed_out_year"));
					student.setGraduationMarks(rs.getInt("Graduation_Marks"));
					student.setTwelveth(rs.getInt("Inter_Marks"));
					student.setTenth(rs.getInt("SSc_Marks"));
					student.setBatchId(rs.getString("Batch_id"));
					student.setEmployeeType(rs.getString("Emp_type"));
					student.setCoreSkill(rs.getString("core_skill"));
					student.setPreferredStudentStream(rs.getString("Preferred_Student_Stream"));
					student.setAssignedStream(rs.getString("Assigned_Stream"));
					student.setDoj(rs.getString("Date_Of_Joining"));
					student.setMentorName(rs.getString("mentor_name"));
					student.setAssignedLocation(rs.getString("Assigned_location"));
					student.setRelocation(rs.getString("relocation"));
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
