package com.epam.services.admin;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.epam.dao.admin.StudentBean;

public class ViewStudentInfoServiceImpl implements ViewStudentInfoService {

	@Override
	public List<StudentBean> adminStudentDetails(Connection con) {
		List<StudentBean> studentList = new ArrayList<>();
		String sql="call viewStudent('qqq@ss.com');";
		try(CallableStatement cs= con.prepareCall(sql);	ResultSet rs = cs.executeQuery();)
		{
			while(rs.next())
			{
				StudentBean student=new StudentBean();
												 
				 student.setFirstName(rs.getString("first_name"));
				 student.setLastName(rs.getString("last_name"));
				 student.setDob(rs.getDate("date_of_birth")); 
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
				 student.setDateOfJoining(rs.getDate("Date_Of_Joining"));
				 student.setMentorName(rs.getString("mentor_name"));
				 student.setAssignedLocation(rs.getString("Assigned_location"));
				 student.setRelocation(rs.getString("relocation"));
				 student.setStatus(rs.getString("status"));
				 	 
				 studentList.add(student);
									
			}
		}
			
		catch(Exception e)
		{
			studentList=null;
			e.getMessage();
		}
		
		return studentList;
	}

}
