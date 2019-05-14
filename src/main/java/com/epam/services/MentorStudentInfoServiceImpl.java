package com.epam.services;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.epam.dao.MentorStudent;


public class MentorStudentInfoServiceImpl implements MentorStudentInfoService {

	@Override
	public List<MentorStudent> MentorStudentDetails(Connection con) {
		
		List<MentorStudent> studentList = new ArrayList<MentorStudent>();
		try
		{
			/*
			PreparedStatement ps = con.prepareStatement("select * from student_personal_info, student__additional_info where student_personal_info.email_id = student__additional_info.email_id ORDER BY\r\n" + 
					" batch_id DESC\r\n" + 
					"LIMIT 10;");
			*/
			String sql = "call mentorStudent();";
			CallableStatement cs= con.prepareCall(sql);
			ResultSet rs = cs.executeQuery();
			
			if(rs!=null)
			{
			while(rs.next())
			{
				MentorStudent student=new MentorStudent();
				String fname=rs.getString("first_name");
				String lname=rs.getString("last_name");
				String name=fname+" "+lname;
				student.setName(name);
				student.setBatch(rs.getString("batch_id"));
				student.setCoreSkill(rs.getString("core_skill"));
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
