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
	
	private static final Logger LOGGER = Logger.getLogger(StudentServiceImpl.class);
	Connection connection = null;
	int numberOfRowsInserted=0;
	 int numberOfRowsInserted1=0;
	 int numberOfRowsInserted2=0;
	 
	 String query = null;
	
	  public  int addPersonalInfo(StudentBean studentBean)
	  {
		  try {
			   connection = DBManager.getConnection();
			   preparedStatement = connection.prepareStatement("select Email_Id from student_personal_info where Email_Id=?");
			   preparedStatement.setString(1, studentBean.getEmail());
			   resultSet = preparedStatement.executeQuery();
			   if(resultSet.next())
			   {
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
      public int addEducationalInfo(StudentBean studentBean)
      {
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
    	  catch(SQLException e)
    	  {
    		  LOGGER.debug(e.getMessage());
    		  return 0;
    	  }
    	  return numberOfRowsInserted1;
      }
	  
      public int addAddtionalInfo(StudentBean studentBean)
      {
    	  
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
  				emailId = resultSet.getString("Email_Id");
  			}
  			
  			preparedStatement.setString(8, emailId);
  			preparedStatement.setString(9, studentBean.getAssignedLocation());
  			preparedStatement.setString(10, studentBean.getRelocation());
  			preparedStatement.setString(11, studentBean.getStatus());
			
		 numberOfRowsInserted2 = preparedStatement.executeUpdate();
    	  }
    	  catch(SQLException e)
    	  {
    		 LOGGER.debug(e.getMessage());
    		 return 0;
    	  }
    	  
    	  return numberOfRowsInserted2;
      }
      
	public int addStudentDetails(StudentBean studentBean) {
		try
		{
	             int numberofrow = addPersonalInfo(studentBean);
	             int numberofrow1 = 0;
	             int numberofrow2 =0;
	             if(numberofrow!=0)
	             {
	            	  numberofrow1=addEducationalInfo(studentBean);
		              numberofrow2=addAddtionalInfo(studentBean);
	             }
	             
	            
	            /* if(numberofrow == 2)
	             {
	            	 result =2;
	             }*/
	              if((numberofrow>0)&& (numberofrow1>0)&& (numberofrow2>0))
			    {
			    	result = 1;
			    	
			    }
			    else
			    {
			    	result = 0;
			    	
			    }
		    
		}
		catch(Exception e)
		{
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
	
	public List<CollegeBean> getCollegNames()
	{
		List<CollegeBean> collegeNameList=new ArrayList();
		try {
			
			Connection connection = DBManager.getConnection();
				String collegeName = null;
				String collegeLocation = null;
				
				PreparedStatement preparedStatement = connection.prepareStatement("select college_name,Location from student_college_info");
				ResultSet resultSet = preparedStatement.executeQuery();
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

	public List<String> getBatchID()
	{
		List<String> batchIDList=new ArrayList<String>();
		try {
			
			Connection connection = DBManager.getConnection();
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
	
	public List<String> getEmployeeType()
	{
		List<String> employeeTypeList = new ArrayList<String>();
		try {
			
			Connection connection = DBManager.getConnection();
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
	
	
	
	public List<String> getcoreSkill()
	{
		List<String> coreSkills = new ArrayList<String>();
		try {
			
			Connection connection = DBManager.getConnection();
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
	public List<String> getPreferredStream()
	{
		List<String> preferredStreams = new ArrayList<String>();
		try {
			
			Connection connection = DBManager.getConnection();
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
	public List<String> getAssignedStream()
	{
		List<String> assignedStreams = new ArrayList<String>();
		try {
			
			Connection connection = DBManager.getConnection();
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
	public List<String> getStatus()
	{
		List<String> statusList = new ArrayList<String>();
		try {
			
			Connection connection = DBManager.getConnection();
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
	public List<String> getMentor()
	{
		List<String> mentorList = new ArrayList<String>();
		try {
			
			Connection connection = DBManager.getConnection();
			 String mentorName = "";
	         preparedStatement = connection.prepareStatement("select Mentor_Name from mentor_info");
	         resultSet = preparedStatement.executeQuery();
	        while(resultSet.next())
	        {
	        	mentorName = resultSet.getString("Mentor_Name");
	         mentorList.add(mentorName);
				}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage()); 
		}
		
		return mentorList;
		
	}
	public List<String> getAssignedLocation()
	{
		List<String> assignedLocationList = new ArrayList<String>();
		try {
			
			Connection connection = DBManager.getConnection();
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
	
}		
			
			
			
			
			
			
			
			
			
		
	
	
	 


