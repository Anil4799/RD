package com.epam.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;


import com.epam.dao.Student;

public class StudentInfoServiceImpl implements StudentInfoService {

	@Override
	public List<Student> getAllStudentDetails(Connection con) {
		
		List<Student> studentList = new ArrayList<Student>();
		
		try
		{
			String sql="call student();";
			CallableStatement cs= con.prepareCall(sql);
			ResultSet rs = cs.executeQuery();
			
			if(rs!=null)
			{
			while(rs.next())
			{
				Student student=new Student();
				String fname=rs.getString("first_name");
				String lname=rs.getString("last_name");
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
			//studentList=null;
			e.getMessage();
		}
		
		return studentList;
	}

}
