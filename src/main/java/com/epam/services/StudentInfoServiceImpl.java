package com.epam.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.dao.Mentor;
import com.epam.dao.Student;

public class StudentInfoServiceImpl implements StudentInfoService {

	@Override
	public List<Student> getAllStudentDetails(Connection con) {
		
		List<Student> studentList = new ArrayList<Student>();
		try
		{

			Statement stmt=con.createStatement();
			String sql="SELECT * FROM student_info";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs!=null)
			{
			while(rs.next())
			{
				Student student=new Student();
				student.setName(rs.getString("name"));
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
