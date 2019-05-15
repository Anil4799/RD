package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.epam.dao.mentor.MentorStudent;
import com.epam.services.mentor.MentorStudentInfoServiceImpl;
import com.epam.utils.DBManager;

class Mentor_Student_List_Test {
	static DBManager db;
	static MentorStudentInfoServiceImpl mentorstudent;
	static Connection con=null;
	List<MentorStudent> lsactual=null;
	@BeforeAll
	static void  initializer()
	{
		mentorstudent=new MentorStudentInfoServiceImpl();
		db=new DBManager();
	}
     
	@Test
	void test1() throws Exception
	{  
	lsactual =mentorstudent.mentorStudentDetails(DBManager.getConnection(),  "ab@gmail.com");
	MentorStudent s= lsactual.get(1);
	String name=null;
	String batch=null;
	String coreSkill=null;
	String email=null;
	String status=null;
		name=s.getName();
		batch=s.getBatch();
		coreSkill=s.getCoreSkill();
		status=s.getStatus();
		email = s.getEmail();
		assertNotNull(name);
		assertNotNull(batch);
		assertNotNull(coreSkill);
		assertNotNull(email);
		assertNotNull(status);
		
		
	}

}
