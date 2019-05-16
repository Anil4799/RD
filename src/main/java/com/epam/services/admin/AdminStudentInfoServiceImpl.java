package com.epam.services.admin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;
import com.epam.dao.admin.AdminStudent;

public class AdminStudentInfoServiceImpl implements AdminStudentInfoService {

	@Override
	public List<AdminStudent> getAllStudentDetails(Connection con) {
		
		List<AdminStudent> studentList = new ArrayList<>();
		String sql="call student();";
		try(CallableStatement cs= con.prepareCall(sql);	ResultSet rs = cs.executeQuery();)
		{
			while(rs.next())
			{
				AdminStudent student=new AdminStudent();
				String firstName=rs.getString(1);
				String lastName=rs.getString(2);
				String name=firstName+" "+lastName;
				student.setName(name);
				student.setBatch(rs.getString("batch_id"));
				student.setCoreSkill(rs.getString("core_skill"));
				student.setMentor(rs.getString("mentor_name"));
				student.setStatus(rs.getString("status"));	
				studentList.add(student);
			}
		}
			
		catch(Exception e)
		{
			studentList=null;
			e.getMessage();
		}
		
		return studentList;
	}

}
