package com.epam.student.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import com.epam.student.beans.StudentBean;
import com.epam.utils.DBManager;

public class StudentServiceImpl implements StudentService {

	boolean result = false;
	PreparedStatement preparedStatement = null;
	Connection connection = DBManager.getConnection();
	int numberOfRowsInserted=0;
	 int numberOfRowsInserted1=0;
	 int numberOfRowsInserted2=0;
	
	  public  int addPersonalInfo(StudentBean studentBean)
	  { try {
		  preparedStatement = connection.prepareStatement("insert into student_personal_info values(?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1, studentBean.getFirstName());
			preparedStatement.setString(2, studentBean.getLastName());
			
			  Date dateOfBirth = studentBean.getDob();
			  java.sql.Date dateOfBirth1 = new java.sql.Date(dateOfBirth.getTime()); 
			  preparedStatement.setDate(3, dateOfBirth1);
			 
			preparedStatement .setString(4, studentBean.getEmail());
			preparedStatement.setString(5, studentBean.getGender());
			preparedStatement.setLong(6, studentBean.getContactNumber());
			preparedStatement.setString(7, studentBean.getPersonalLocation());
			
			numberOfRowsInserted	 = preparedStatement.executeUpdate();
			
	  }
	  catch(Exception e)
	  {
		  return 0;
	  }
	return numberOfRowsInserted;
	
		  
	  }
      public int addEducationalInfo(StudentBean studentBean)
      {
    	  try {
    	  preparedStatement = connection.prepareStatement("insert into student_educational_info values(?,?,?,?,?,?,?,?,?)");
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
    	  catch(Exception e)
    	  {
    		  return 0;
    	  }
    	  return numberOfRowsInserted1;
      }
	  
      public int addAddtionalInfo(StudentBean studentBean)
      {
    	  
    	  try {
    	  preparedStatement = connection.prepareStatement("insert into  student__additional_info values(?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, studentBean.getEmail());
			System.out.println("batch id::::::::::"+studentBean.getBatchId());
			preparedStatement.setString(2, studentBean.getBatchId());
			preparedStatement.setString(3, studentBean.getEmployeeType());
			preparedStatement.setString(4, studentBean.getCoreSkill());
			preparedStatement.setString(5, studentBean.getPreferredStudentStream());
			preparedStatement.setString(6, studentBean.getAssignedStream());
			Date dateOfJoining = studentBean.getDateOfJoining();
			java.sql.Date dateOfJoining1 = new java.sql.Date(dateOfJoining.getTime()); 
			preparedStatement.setDate(7, dateOfJoining1);
			preparedStatement.setString(8, studentBean.getMentorName());
			preparedStatement.setString(9, studentBean.getAssignedLocation());
			preparedStatement.setString(10, studentBean.getRelocation());
			preparedStatement.setString(11, studentBean.getStatus());
			
		 numberOfRowsInserted2 = preparedStatement.executeUpdate();
    	  }
    	  catch(Exception e)
    	  {
    		  return 0;
    	  }
    	  return numberOfRowsInserted2;
      }
      
	public boolean addStudentDetails(StudentBean studentBean) {
		
		
	             int numberofrow=addPersonalInfo(studentBean);
	             int numberofrow1=addEducationalInfo(studentBean);
	             int numberofrow2=addAddtionalInfo(studentBean);
		    if((numberofrow>0)&& (numberofrow1>0)&& (numberofrow2>0))
		    {
		    	return true;
		    }
		    else
		    {
		    	return false;
		    }
			 
	}}		
			
			
			
			
			
			
			
			
			
		
	
	
	 


