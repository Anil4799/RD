package com.epam.services.admin;

import java.sql.Connection;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.epam.dao.admin.CollegeBean;
import com.epam.dao.admin.StudentBean;
import com.epam.utils.DBManager;

public class StudentServiceImpl implements StudentService {

	int result = 0;
	PreparedStatement preparedStatement = null;
	PreparedStatement preparedStatementOne = null;
	ResultSet resultSet=null ;
	ResultSet resultSetOne=null;
	private static final Logger LOGGER = Logger.getLogger(StudentServiceImpl.class);
	Connection connection = null;
	int numberOfRowsInserted=0;
	int numberOfRowsInserted1=0;
	int numberOfRowsInserted2=0;
	int numberOfRowsUpdated1 = 0;
	int numberOfRowsUpdated2 = 0;
	int numberOfRowsUpdated3 = 0;
	private static final  String MENTORNAME="Mentor_Name";
	private static final  String EMAILID="Email_Id";

	String query = null;
	int existing_email=0;
	public  int addPersonalInfo(StudentBean studentBean){
		try {
			   connection = DBManager.getConnection();
			   preparedStatement = connection.prepareStatement("select Email_Id from student_personal_info where Email_Id=?");
			   preparedStatement.setString(1, studentBean.getEmail());
			   resultSet = preparedStatement.executeQuery();
			   if(resultSet.next())
			   {
				   existing_email = 1;
				   numberOfRowsInserted = 0;
				   return numberOfRowsInserted;
			   }
			   			   			   
			   query = "insert into student_personal_info(First_Name, Last_Name, Date_Of_Birth, Email_Id, Gender, Contact, Location) values(?,?,?,?,?,?,?)";
			   preparedStatement = connection.prepareStatement(query);
				
			   preparedStatement.setString(1, studentBean.getFirstName());
			   preparedStatement.setString(2, studentBean.getLastName());
			   
			   Date dateOfBirth = studentBean.getDob();
			   java.sql.Date dateOfBirth1 = new java.sql.Date(dateOfBirth.getTime()); 
			   preparedStatement.setDate(3, dateOfBirth1);
				 
			   preparedStatement .setString(4, studentBean.getEmail());
			   preparedStatement.setString(5, studentBean.getGender());
			   preparedStatement.setLong(6, studentBean.getContactNumber());
			   preparedStatement.setString(7, studentBean.getPersonalLocation());
				
			   numberOfRowsInserted = preparedStatement.executeUpdate();			
		  }
		  catch(SQLException  e)
		  {
			  LOGGER.debug(e.getMessage());
			  return 0;
		  }
		  return numberOfRowsInserted;			  
	  }
      public int addEducationalInfo(StudentBean studentBean){
    	  try {
    		  	connection = DBManager.getConnection();
    		  	query = "insert into student_educational_info(Email_Id, College_Name, College_Loc, Graduation, Graduation_Stream, Passed_Out_Year, Graduation_Marks, Inter_Marks, Ssc_Marks) values (?,?,?,?,?,?,?,?,?)";
	  			preparedStatement = connection.prepareStatement(query);
	  			preparedStatement.setString(1, studentBean.getEmail());
	  			
	  			preparedStatement.setString(2, studentBean.getCollegeName());
	  			
	  			preparedStatement.setString(3, studentBean.getCollegeLocation());
	  			preparedStatement.setString(4, studentBean.getGraduation());
	  			preparedStatement.setString(5, studentBean.getGraduationSpeciality());
	  			preparedStatement.setInt(6, studentBean.getYearOfPassedOut());
	  			preparedStatement.setInt(7, studentBean.getGraduationMarks());
	  			preparedStatement.setInt(8, studentBean.getTwelveth());
	  			preparedStatement.setInt(9, studentBean.getTenth());
			
	  			numberOfRowsInserted1 = preparedStatement.executeUpdate();
    	  }

    	  catch(SQLException e)  {
    		  LOGGER.debug(e.getMessage());
    		  return 0;
    	  }
    	  return numberOfRowsInserted1;
      }
	  
      public int addAddtionalInfo(StudentBean studentBean){    	  
    	  try {
    		  	connection = DBManager.getConnection();
    		  	query = "insert into  student__additional_info(Email_Id, Batch_Id, Emp_Type, Core_Skill, Preferred_Student_Stream, Assigned_Stream, Date_Of_Joining, Mentor_Name, Assigned_Location, Relocation, Status) values(?,?,?,?,?,?,?,?,?,?,?)";						
	  			preparedStatement = connection.prepareStatement(query);
	  			preparedStatement.setString(1, studentBean.getEmail());
	  			preparedStatement.setString(2, studentBean.getBatchId());
	  			preparedStatement.setString(3, studentBean.getEmployeeType());
	  			preparedStatement.setString(4, studentBean.getCoreSkill());
	  			preparedStatement.setString(5, studentBean.getPreferredStudentStream());
	  			preparedStatement.setString(6, studentBean.getAssignedStream());
	  			Date dateOfJoining = studentBean.getDateOfJoining();
	  			java.sql.Date dateOfJoining1 = new java.sql.Date(dateOfJoining.getTime()); 
	  			preparedStatement.setDate(7, dateOfJoining1);
	  			
	  			query = "select  Email_Id from mentor_info where Mentor_Name = ?";
	  			preparedStatementOne = connection.prepareStatement(query);
	  			preparedStatementOne.setString(1, studentBean.getMentorName());
	  			resultSet = preparedStatementOne.executeQuery();
	  			String emailId = "";
	  			if(resultSet.next())
	  			{
	  				emailId = resultSet.getString(EMAILID);
	  			}
  			
	  			preparedStatement.setString(8, emailId);
	  			preparedStatement.setString(9, studentBean.getAssignedLocation());
	  			preparedStatement.setString(10, studentBean.getRelocation());
	  			preparedStatement.setString(11, studentBean.getStatus());
				
	  			numberOfRowsInserted2 = preparedStatement.executeUpdate();
    	  }

    	  catch(SQLException e){
    		 LOGGER.debug(e.getMessage());
    		 return 0;
    	  }    	  
    	  return numberOfRowsInserted2;
      }
      
      public int addStudentDetails(StudentBean studentBean) {
		try	{
             int numberofrow = addPersonalInfo(studentBean);
             int numberofrow1 = 0;
             int numberofrow2 =0;
             if(numberofrow!=0){
            	  numberofrow1=addEducationalInfo(studentBean);
	              numberofrow2=addAddtionalInfo(studentBean);
             }	
             if(existing_email == 1) {
            	 result = 2;
             }
             if((numberofrow>0)&& (numberofrow1>0)&& (numberofrow2>0)) {	             
		    	result = 1;		
             }
             else{             
		    	result = 0;	
             }

		}

		catch(Exception e){
			 LOGGER.debug(e.getMessage()); 
		}
		finally {
  			try {
  				resultSet.close();
  				preparedStatementOne.close();
  				preparedStatement.close();
  				connection.close();
  			} catch (SQLException e) {
  				LOGGER.debug(e.getMessage());
  			}  			  			
  		}
		 LOGGER.debug("Exit from StudentServiceImpl Class..............."); 
		    return result;
	}
	
	public List<CollegeBean> getCollegNames(){
		List<CollegeBean> collegeNameList=new ArrayList<>();
		try {			
			connection = DBManager.getConnection();			
				
			preparedStatement = connection.prepareStatement("select college_name,Location from student_college_info");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				CollegeBean college=new CollegeBean();
				college.setCollegeName(resultSet.getString("college_name"));
				college.setCollegeLocation(resultSet.getString("Location"));
				collegeNameList.add(college);
		   }
		} catch (Exception e) {
			LOGGER.debug(e.getMessage()); 
		}
		
		return collegeNameList;
	}

	public List<String> getBatchID(){
		List<String> batchIDList=new ArrayList<>();
		try {			
			connection = DBManager.getConnection();
				String batchId = null;
				
				preparedStatement = connection.prepareStatement("select Batch_Id from batch_info");
		         resultSet = preparedStatement.executeQuery();
		        while(resultSet.next())
		        {
		         batchId = resultSet.getString("Batch_Id");
		         batchIDList.add(batchId);
		        
		        }
		} catch (Exception e) {
			LOGGER.debug(e.getMessage()); 
		}
		
		return batchIDList;
	}
	
	public List<String> getEmployeeType(){
		List<String> employeeTypeList = new ArrayList<>();
		try {			
			connection = DBManager.getConnection();
			String employeeType = null;
			
			preparedStatement = connection.prepareStatement("select Employee_Type from employee_type");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				employeeType = resultSet.getString("employee_type");
				employeeTypeList.add(employeeType);
            }
		} catch (Exception e) {
			LOGGER.debug(e.getMessage()); 
		}
		
		return employeeTypeList;
	}
		
	public List<String> getcoreSkill(){
		List<String> coreSkills = new ArrayList<>();
		try {			
			connection = DBManager.getConnection();
			String skill = "";
			preparedStatement = connection.prepareStatement("select Skill_Name from core_skill");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				skill = resultSet.getString("Skill_Name");
				coreSkills.add(skill);	
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage()); 
		}
		
		return coreSkills;
	}
	public List<String> getPreferredStream(){
		List<String> preferredStreams = new ArrayList<>();
		try {			
			connection = DBManager.getConnection();
			String streamName = "";
			preparedStatement = connection.prepareStatement("select Stream_Name from technical_stream");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{				
				streamName = resultSet.getString("Stream_Name");
				preferredStreams.add(streamName);	
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage()); 
		}
		
		return preferredStreams;
	}
	public List<String> getAssignedStream()	{
		List<String> assignedStreams = new ArrayList<>();
		try {			
			connection = DBManager.getConnection();
			String assignedStream = "";
			preparedStatement = connection.prepareStatement("select Stream_Name from technical_stream");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{				
				assignedStream = resultSet.getString("Stream_Name");
				assignedStreams.add(assignedStream);	
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage()); 
		}		
		return assignedStreams;
	}
	public List<String> getStatus()	{
		List<String> statusList = new ArrayList<>();
		try {			
			connection = DBManager.getConnection();
			String employeeStatus = "";
			preparedStatement = connection.prepareStatement("select Employee_Status from Employee_Status");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				employeeStatus = resultSet.getString("Employee_Status");
			
				statusList.add(employeeStatus);	
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage()); 
		}
		
		return statusList;
	}
	public List<String> getMentor()	{
		List<String> mentorList = new ArrayList<>();
		try {			
			 connection = DBManager.getConnection();
			 String mentorName = "";
	         preparedStatement = connection.prepareStatement("select Mentor_Name from mentor_info");
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next())
	         {
	        	mentorName = resultSet.getString(MENTORNAME);
	        	mentorList.add(mentorName);
	         }
		} catch (Exception e) {
			LOGGER.debug(e.getMessage()); 
		}		
		return mentorList;		
	}
	public List<String> getAssignedLocation(){
		List<String> assignedLocationList = new ArrayList<>();
		try {			
			connection = DBManager.getConnection();
			String assignedLocation = "";
			preparedStatement = connection.prepareStatement("select Assigned_Location from assigned_location");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				assignedLocation = resultSet.getString("Assigned_Location");
				assignedLocationList.add(assignedLocation);
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage()); 
		}		
		return assignedLocationList;
	}
	
	public StudentBean getDetails(String emailId){
		StudentBean studentBean = new StudentBean();
		try {
			connection = DBManager.getConnection();
				
			query = "select First_Name, Last_Name, DATE_FORMAT(Date_Of_Birth, '%m-%d-%Y') Date_Of_Birth, Email_Id, Gender, Contact, Location from student_personal_info where Email_Id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, emailId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				studentBean.setFirstName(resultSet.getString("First_Name"));
				studentBean.setLastName(resultSet.getString("Last_Name"));
				
				String dobStr = resultSet.getString("Date_Of_Birth");
				studentBean.setStrDob(dobStr);									
				studentBean.setEmail(resultSet.getString(EMAILID));
				studentBean.setGender(resultSet.getString("Gender"));
				studentBean.setContactNumber(resultSet.getLong("Contact"));
				studentBean.setPersonalLocation(resultSet.getString("Location"));
		   }				
			query = "select Email_Id, College_Name, College_Loc, Graduation, Graduation_Stream, Passed_Out_Year, Graduation_Marks, Inter_Marks, Ssc_Marks  from student_educational_info  where Email_Id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, emailId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				studentBean.setCollegeName(resultSet.getString("College_Name"));
				studentBean.setCollegeLocation(resultSet.getString("College_Loc"));
				studentBean.setGraduation(resultSet.getString("Graduation"));
				studentBean.setGraduationSpeciality(resultSet.getString("Graduation_Stream"));
				studentBean.setYearOfPassedOut(resultSet.getInt("Passed_Out_Year"));
				studentBean.setGraduationMarks(resultSet.getInt("Graduation_Marks"));
				studentBean.setTwelveth(resultSet.getInt("Inter_Marks"));
				studentBean.setTenth(resultSet.getInt("Ssc_Marks"));					
			}
			query = "select SerialNo, Email_Id, Batch_Id, Emp_Type, Core_Skill, Preferred_Student_Stream, Assigned_Stream, DATE_FORMAT(Date_Of_Joining, '%m-%d-%Y') Date_Of_Joining, Mentor_Name, Assigned_Location, Relocation, Status from student__additional_info where Email_Id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, emailId);
			resultSet = preparedStatement.executeQuery();
			 
			if(resultSet.next()) {				
				String query1 =  "select Mentor_Name from mentor_info where Email_Id=?";
				preparedStatementOne = connection.prepareStatement(query1);
				preparedStatementOne.setString(1, resultSet.getString(MENTORNAME));
				resultSetOne = preparedStatementOne.executeQuery();
				if(resultSetOne.next())
				{
					studentBean.setMentorName(resultSetOne.getString(MENTORNAME));
				}				 
				studentBean.setEmail(resultSet.getString(EMAILID));
				studentBean.setBatchId(resultSet.getString("Batch_Id"));
				studentBean.setEmployeeType(resultSet.getString("Emp_Type"));
				studentBean.setCoreSkill(resultSet.getString("Core_Skill"));
				studentBean.setPreferredStudentStream(resultSet.getString("Preferred_Student_Stream"));
				studentBean.setAssignedStream(resultSet.getString("Assigned_Stream"));
				
				String strDateOfJoining = resultSet.getString("Date_Of_Joining");
				studentBean.setStrDateOfJoining(strDateOfJoining);										
				studentBean.setAssignedLocation(resultSet.getString("Assigned_Location"));
				studentBean.setRelocation(resultSet.getString("Relocation"));
				studentBean.setStatus(resultSet.getString("Status"));													
			}						

		} catch (Exception e) {
			LOGGER.debug(e.getMessage()); 
		}	
		finally {
  			try {
  				resultSet.close();
  				resultSetOne.close();
  				preparedStatementOne.close();
  				preparedStatement.close();
  				connection.close();
  			} catch (SQLException e) {
  				LOGGER.debug(e.getMessage());
  			}  			  			
  		}
		return studentBean;
	}	
	public int editPersonalDetails(StudentBean studentBean) {
		try	{
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement("update student_personal_info set Date_Of_Birth=?, Gender=?, Contact=?, Location=? where Email_Id=?");
			Date dateOfBirth = studentBean.getDob();
			java.sql.Date dateOfBirth1 = new java.sql.Date(dateOfBirth.getTime()); 
			preparedStatement.setDate(1, dateOfBirth1);
			preparedStatement.setString(2, studentBean.getGender());
			preparedStatement.setLong(3, studentBean.getContactNumber());
			preparedStatement.setString(4, studentBean.getPersonalLocation());
			preparedStatement.setString(5, studentBean.getEmail());
			   
			numberOfRowsUpdated1 = preparedStatement.executeUpdate();
			
		} catch(Exception e) {
			 LOGGER.debug(e.getMessage());
		}
		return numberOfRowsUpdated1;
	}
	
	public int editEducationalDetails(StudentBean studentBean) {
		try {
			 String updateQuery = "update student_educational_info set College_Name=?, College_Loc=?, Graduation=?, Graduation_Stream=?, Passed_Out_Year=?, Graduation_Marks=?, Inter_Marks=?, Ssc_Marks=? where Email_Id=?";
			 preparedStatement = connection.prepareStatement(updateQuery);			   			   
			 String collegeNameAndLocation = studentBean.getCollegeName();
			 String collegeName = "";
			 collegeName = extractCollegeName(collegeNameAndLocation, collegeName);
			 studentBean.setCollegeName(extractCollegeName(collegeNameAndLocation, collegeName));
			   			   
			 preparedStatement.setString(1, studentBean.getCollegeName());
	 		 preparedStatement.setString(2, studentBean.getCollegeLocation());
	 		 preparedStatement.setString(3, studentBean.getGraduation());
	 		 preparedStatement.setString(4, studentBean.getGraduationSpeciality());
	 		 preparedStatement.setInt(5, studentBean.getYearOfPassedOut());
	 		 preparedStatement.setInt(6, studentBean.getGraduationMarks());
	 		 preparedStatement.setInt(7, studentBean.getTwelveth());
	 		 preparedStatement.setInt(8, studentBean.getTenth());
	 		 preparedStatement.setString(9, studentBean.getEmail());	 			
				
			 numberOfRowsUpdated2 = preparedStatement.executeUpdate();
				 
		} catch(Exception e) {
			LOGGER.debug(e.getMessage());
		}
		return numberOfRowsUpdated2;
	}
	
	public int editAdditionalDetails(StudentBean studentBean) {
		try {
			 String updateQuery = "update student__additional_info set Emp_Type=?, Core_Skill=?, Preferred_Student_Stream=?, Assigned_Stream=?, Mentor_Name=?, Assigned_Location=?, Relocation=?, Status=? where Email_Id=?";			
			 preparedStatement = connection.prepareStatement(updateQuery);
	  						 
  			 preparedStatement.setString(1, studentBean.getEmployeeType());
	  			
	  		 preparedStatement.setString(2, studentBean.getCoreSkill());
	  		 preparedStatement.setString(3, studentBean.getPreferredStudentStream());
	  		 preparedStatement.setString(4, studentBean.getAssignedStream());
	  		 String mentorName = studentBean.getMentorName();	  			
	  			
	  		 String query1 =  "select Email_Id from mentor_info where Mentor_Name=?";
			 preparedStatementOne = connection.prepareStatement(query1);
			 preparedStatementOne.setString(1, mentorName);
			 resultSetOne = preparedStatementOne.executeQuery();
			 String name = "";
			 if(resultSetOne.next())
			 {
				name =  resultSetOne.getString(EMAILID);
			 }
			 				 							 	  			
  			 preparedStatement.setString(5, name);	  			
  			 preparedStatement.setString(6, studentBean.getAssignedLocation());
  			 preparedStatement.setString(7, studentBean.getRelocation());
  			 preparedStatement.setString(8, studentBean.getStatus());	  			
  			 preparedStatement.setString(9, studentBean.getEmail());
	  			
			 numberOfRowsUpdated3 = preparedStatement.executeUpdate();
		} 
		catch(Exception e) {
			LOGGER.debug(e.getMessage());
		}
		return numberOfRowsUpdated3;
	}
	public int editStudentDetails(StudentBean studentBean)	{
		try {
			int rowsUpdated1 = editPersonalDetails(studentBean);
			int rowsUpdated2 = editEducationalDetails(studentBean);
			int rowsUpdated3 = editAdditionalDetails(studentBean);
			result = 0; 			 	  
			if(rowsUpdated1>0 && rowsUpdated2>0 && rowsUpdated3>0)		{			 
				 result = 1;
			}			
			else {
				result = 0;
			}
		}
		catch(Exception e) {
			 LOGGER.debug(e.getMessage());
		}
		finally {
  			try {
  				
  				preparedStatement.close();
  				connection.close();
  			} catch (SQLException e) {
  				LOGGER.debug(e.getMessage());
  			}  			  			
  		}
		return result;
	}
	
	private String extractCollegeName(String collegeNameAndLocation, String collegeName) {
		if(!collegeNameAndLocation.contains("$"))
		{
			collegeName = collegeNameAndLocation;
		}
		else if(!collegeNameAndLocation.equals(""))
		{
			collegeName = collegeNameAndLocation.substring(0,collegeNameAndLocation.indexOf('$'));
		}
		return collegeName;
	}
		
	public List<String> getGraduationSpeciality()
	{
		List<String> graduationSpecialityList = new ArrayList<>();
		try {			
			 connection = DBManager.getConnection();
			 String graduationSpeciality = null;				
			 preparedStatement = connection.prepareStatement("select Graduation_Speciality from Graduation_Speciality");
		     resultSet = preparedStatement.executeQuery();
	         while(resultSet.next())
	         {
	        	graduationSpeciality = resultSet.getString("Graduation_Speciality");
	        	graduationSpecialityList.add(graduationSpeciality);
	        
	         }
		} catch (Exception e) {
			LOGGER.debug(e.getMessage()); 
		}		
		return graduationSpecialityList;
	}
}		
			
			
			
			
			
			
			
			
			
		
	
	
	 


