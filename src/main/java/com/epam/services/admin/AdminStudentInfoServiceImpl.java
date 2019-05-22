package com.epam.services.admin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;
import com.epam.dao.admin.Student;

public class AdminStudentInfoServiceImpl implements AdminStudentInfoService {

	@Override
	public List<Student> getAllStudentDetails(Connection con) {
		
		List<Student> studentList = new ArrayList<>();
		String sql="call student();";
		try(CallableStatement cs= con.prepareCall(sql);	ResultSet rs = cs.executeQuery();)
		{
			while(rs.next())
			{
				Student student=new Student();
				String firstName=rs.getString("first_name");
				String lastName=rs.getString("last_name");
				String name=firstName+" "+lastName;
				student.setStudentName(name);
				student.setStudentBatch(rs.getString("batch_id"));
				student.setStudentCoreSkill(rs.getString("core_skill"));
				student.setStudentMentor(rs.getString("mentor_name"));
				student.setStudentStatus(rs.getString("status"));	
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
