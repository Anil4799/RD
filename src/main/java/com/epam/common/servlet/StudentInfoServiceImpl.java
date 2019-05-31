package com.epam.common.servlet;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.epam.dao.admin.StudentBean;

public class StudentInfoServiceImpl implements StudentInfoService {
	
	private static final  String CORESKILL="core_skill";
	private static final  String FIRSTNAME="first_name";
	private static final  String LASTNAME="last_name";
	private static final  String EMAILID="email_id";
	private static final  String BATCHID="batch_id";
	private static final  String MENTORNAME="mentor_name";
	private static final  String STATUS="status";

	@Override
	public List<StudentBean> getAllStudentDetails(Connection con) {
		List<StudentBean> studentList = new ArrayList<>();
		String sql="call student();";
		try(CallableStatement cs= con.prepareCall(sql);	ResultSet rs = cs.executeQuery();){
			while(rs.next()){
				StudentBean student=new StudentBean();
				student.setFirstName(rs.getString(FIRSTNAME));
				student.setLastName(rs.getString(LASTNAME));
				student.setEmail(rs.getString(EMAILID));
				student.setBatchId(rs.getString(BATCHID));
				student.setCoreSkill(rs.getString(CORESKILL));
				student.setMentorName(rs.getString(MENTORNAME));
				student.setStatus(rs.getString(STATUS));
				studentList.add(student);
			}
		}catch(Exception e){
			studentList=null;
			e.getMessage();
		}
		return studentList;
	}

	@Override
	public List<StudentBean> getAllSearchStudentDetails(Connection con, String firstNamedb,String lastNamedb,String batchIDdb) {
		List<StudentBean> studentList = new ArrayList<>();
		String sql="call search_admin_student(?,?,?);";
		try(CallableStatement cs= con.prepareCall(sql);	){
			cs.setString(1, firstNamedb);
			cs.setString(2, lastNamedb);
			cs.setString(3, batchIDdb);
			try (ResultSet rs = cs.executeQuery();){
			while(rs.next()){
				StudentBean student=new StudentBean();
				student.setFirstName(rs.getString(FIRSTNAME));
				student.setLastName(rs.getString(LASTNAME));
				student.setEmail(rs.getString(EMAILID));
				student.setBatchId(rs.getString(BATCHID));
				student.setCoreSkill(rs.getString(CORESKILL));
				student.setMentorName(rs.getString(MENTORNAME));
				student.setStatus(rs.getString(STATUS));
				studentList.add(student);
			}
			}
			
		}catch(Exception e){
			studentList=null;
		}
		return studentList;
	}
	
	@Override
	public List<StudentBean> getAllSearchStudentDetails(Connection con,String mentorEmailId, String firstNamedb, String lastNamedb,
			String batchIDdb) {
		
		List<StudentBean> studentList = new ArrayList<>();
		String sql="call search_mentor_student(?,?,?,?);";
		try(CallableStatement cs= con.prepareCall(sql);){
			cs.setString(1, mentorEmailId);
			cs.setString(2, firstNamedb);
			cs.setString(3, lastNamedb);
			cs.setString(4, batchIDdb);
			try(ResultSet rs = cs.executeQuery();){
				while(rs.next()){
					StudentBean student=new StudentBean();
					student.setFirstName(rs.getString(FIRSTNAME));
					student.setLastName(rs.getString(LASTNAME));
					student.setEmail(rs.getString(EMAILID));
					student.setBatchId(rs.getString(BATCHID));
					student.setCoreSkill(rs.getString(CORESKILL));
					student.setStatus(rs.getString(STATUS));	
					studentList.add(student);
				}
			}
		}catch(Exception e) {
			studentList=null;
		}		
		return studentList;
	}

	@Override
	public List<StudentBean> adminStudentDetails(Connection con, String studentEmailId) {
		List<StudentBean> studentList = new ArrayList<>();
		String sql="call viewStudent(?);";
		try(CallableStatement cs= con.prepareCall(sql);){
			cs.setString(1, studentEmailId);
			try(ResultSet rs = cs.executeQuery();)
			{
			while(rs.next()){
				StudentBean student=new StudentBean();					 
				 student.setFirstName(rs.getString(FIRSTNAME));
				 student.setLastName(rs.getString(LASTNAME));
				 student.setDateOfBirth(rs.getString("date_of_birth")); 
				 student.setEmail(rs.getString(EMAILID));
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
				 student.setCoreSkill(rs.getString(CORESKILL));
				 student.setPreferredStudentStream(rs.getString("Preferred_Student_Stream"));
				 student.setAssignedStream(rs.getString("Assigned_Stream"));
				 student.setDoj(rs.getString("Date_Of_Joining"));
				 student.setMentorName(rs.getString(MENTORNAME));
				 student.setAssignedLocation(rs.getString("Assigned_location"));
				 student.setRelocation(rs.getString("relocation"));
				 student.setStatus(rs.getString(STATUS));
				 studentList.add(student);									
			}
			}
		}catch(Exception e){
			studentList=null;
			e.getMessage();
		}
		return studentList;
	}
	
	
	@Override
	public List<StudentBean> mentorStudentDetails(Connection con, String mentorEmailId) {
		List<StudentBean> studentList = new ArrayList<>();
		String sql = "call mentorStudent(?);";
		try(CallableStatement cs= con.prepareCall(sql);){
			cs.setString(1, mentorEmailId);
			try(ResultSet rs = cs.executeQuery();){
				while(rs.next()){
					StudentBean student=new StudentBean();
					student.setFirstName(rs.getString(FIRSTNAME));
					student.setLastName(rs.getString(LASTNAME));
					student.setEmail(rs.getString(EMAILID));
					student.setBatchId(rs.getString(BATCHID));
					student.setCoreSkill(rs.getString(CORESKILL));
					student.setStatus(rs.getString(STATUS));	
					studentList.add(student);
				}
			}
		}
		catch(Exception e){
			studentList=null;
		}
		return studentList;
	}
	
	@Override
	public List<StudentBean> mentorViewStudentDetails(Connection con, String emailId) {
		List<StudentBean> studentList = new ArrayList<>();
		String sql = "call viewStudent(?);";
		try(CallableStatement cs= con.prepareCall(sql);){
			cs.setString(1, emailId);
			try(ResultSet rs = cs.executeQuery();){
				while(rs.next()){
					StudentBean student=new StudentBean();
					student.setFirstName(rs.getString(FIRSTNAME));
					student.setLastName(rs.getString(LASTNAME));
					student.setDateOfBirth(rs.getString("date_of_birth")); 
					student.setEmail(rs.getString(EMAILID));
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
					student.setCoreSkill(rs.getString(CORESKILL));
					student.setPreferredStudentStream(rs.getString("Preferred_Student_Stream"));
					student.setAssignedStream(rs.getString("Assigned_Stream"));
					student.setDoj(rs.getString("Date_Of_Joining"));
					student.setMentorName(rs.getString(MENTORNAME));
					student.setAssignedLocation(rs.getString("Assigned_location"));
					student.setRelocation(rs.getString("relocation"));
					student.setStatus(rs.getString(STATUS));
					studentList.add(student);
				}
			}
		}catch(Exception e){
			studentList=null;
		}
		return studentList;	
	}
}
