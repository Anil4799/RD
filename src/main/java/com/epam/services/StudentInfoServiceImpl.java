package com.epam.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;


import com.epam.dao.Student;

public class StudentInfoServiceImpl implements StudentInfoService {

	@Override
	public List<Student> getAllStudentDetails(Connection con) {
		
		List<Student> studentList = new ArrayList<Student>();
		try
		{

			PreparedStatement ps = con.prepareStatement("select * from student_personal_info, student__additional_info where student_personal_info.email_id = student__additional_info.email_id;");
			ResultSet rs = ps.executeQuery();
			
			if(rs!=null)
			{
			while(rs.next())
			{
				Student student=new Student();
				String fname=rs.getString(1);
				String lname=rs.getString(2);
				String name=fname+" "+lname;
				student.setName(name);
				student.setBatch(rs.getString("batch_id"));
				student.setCoreSkill(rs.getString("core_skill"));
				student.setMentor(rs.getString("mentor_name"));
				student.setStatus(rs.getString("status"));	
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
