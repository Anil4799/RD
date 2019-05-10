package com.epam.student.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.epam.student.beans.StudentBean;
import com.epam.utils.DBManager;

public class StudentServiceImpl implements StudentService {

	boolean result = false;
	PreparedStatement preparedStatement = null;

	public boolean addStudentDetails(StudentBean studentBean) {
		
		Connection connection = DBManager.getConnection();
	
		
		try {
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
			
			int numberOfRowsInserted = preparedStatement.executeUpdate();
			
			
			
			 
			
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
			
			int numberOfRowsInserted1 = preparedStatement.executeUpdate();
			
			
			/*
			 * preparedStatement =
			 * connection.prepareStatement("insert into student_college_info values(?,?)");
			 * preparedStatement.setString(1, studentBean.getCollegeName());
			 * preparedStatement.setString(2, studentBean.getCollegeLocation());
			 * numberOfRowsInserted2 = preparedStatement.executeUpdate();
			 */
			
			
			
			preparedStatement = connection.prepareStatement("insert into  student__additional_info values(?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, studentBean.getEmail());
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
			
			int numberOfRowsInserted2 = preparedStatement.executeUpdate();
			
			if(numberOfRowsInserted >0 && numberOfRowsInserted1>0 && numberOfRowsInserted2>0)
			{
				result= true;
			}
			
			
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	 

}
