package com.epam.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;

import com.epam.common.servlet.StudentInfoServiceImpl;
import com.epam.dao.mentor.MentorStudent;
import com.epam.utils.DBManager;

import jdk.nashorn.internal.ir.annotations.Ignore;

class MentorStudentListTest {
	static DBManager db;
	static StudentInfoServiceImpl mentorstudent;
	static Connection con=null;
	List<MentorStudent> lsactual=null;
	@BeforeAll
	static void  initializer()
	{
		mentorstudent=new StudentInfoServiceImpl();
		db=new DBManager();
	}
     

	@Ignore
	 void test1() throws Exception {
		
	    con=DBManager.getConnection();
		Statement stmt=con.createStatement();
		String sql="select * from student_personal_info, student__additional_info where student_personal_info.email_id = student__additional_info.email_id";
		ResultSet rs=stmt.executeQuery(sql);
	    int expected=0;
	    while(rs.next())
	    {
	    	expected++;
	    }
		
	
//	MentorStudent s= lsactual.get(1);
//	String name=null;
//	String batch=null;
//	String coreSkill=null;
//	String email=null;
//	String status=null;
//		name=s.getName();
//		batch=s.getBatch();
//		coreSkill=s.getCoreSkill();
//		status=s.getStatus();
//		email = s.getEmail();
//		assertNotNull(name);
//		assertNotNull(batch);
//		assertNotNull(coreSkill);
//		assertNotNull(email);
//		assertNotNull(status);
		
		
	}

}
