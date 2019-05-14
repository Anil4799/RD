package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.epam.dao.Student;
import com.epam.utils.DBManager;

class Student_Info_Test {
	static DBManager db;
	static StudentInfoServiceImpl student;
	static Connection con=null;
	List<Student> lsactual=null;
	@BeforeAll
	static void  initializer()
	{
		student=new StudentInfoServiceImpl();
		db=new DBManager();
	}
     
	@Test
	void test2() throws Exception
	{   lsactual =student.getAllStudentDetails(DBManager.getConnection());
	Student s= lsactual.get(1);
	String name=null;
	String batch=null;
	String coreSkill=null;
	String mentor=null;
	String status=null;
		name=s.getName();
		batch=s.getBatch();
		coreSkill=s.getcoreSkill();
		mentor=s.getMentor();
		status=s.getStatus();
		
		assertNotNull(name);
		assertNotNull(batch);
		assertNotNull(coreSkill);
		assertNotNull(mentor);
		assertNotNull(status);
		
		
	}

}
