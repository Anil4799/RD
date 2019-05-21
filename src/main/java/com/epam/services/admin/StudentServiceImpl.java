package com.epam.services.admin;

import java.sql.Connection;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.epam.dao.admin.StudentBean;
import com.epam.utils.DBManager;

public class StudentServiceImpl implements StudentService {

	boolean result = false;
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
      
	public boolean addStudentDetails(StudentBean studentBean) {
		try
		{
	             int numberofrow=addPersonalInfo(studentBean);
	             int numberofrow1=addEducationalInfo(studentBean);
	             int numberofrow2=addAddtionalInfo(studentBean);
	            
		    if((numberofrow>0)&& (numberofrow1>0)&& (numberofrow2>0))
		    {
		    	result = true;
		    	
		    }
		    else
		    {
		    	result = false;
		    	
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
	
	public List<String> getCollegNames()
	{
		List<String> ls=new ArrayList();
		try {
			
			Connection connection = DBManager.getConnection();
				String collegeName = null, collegeLocation = "";
				PreparedStatement preparedStatement = connection.prepareStatement("select college_name, location from student_college_info");
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next())
				{
					collegeName = resultSet.getString("college_name");
					ls.add(collegeName);
			   }
		} catch (Exception e) {
			LOGGER.debug(e.getMessage()); 
		}
		
		return ls;
	}


}		
			
			
			
			
			
			
			
			
			
		
	
	
	 


