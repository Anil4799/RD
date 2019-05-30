package com.epam.services;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;

import com.epam.common.servlet.StudentInfoServiceImpl;
import com.epam.dao.admin.StudentBean;
import com.epam.utils.DBManager;

import jdk.nashorn.internal.ir.annotations.Ignore;

class StudentInfoTest {
	static DBManager db;
	static StudentInfoServiceImpl student;
	static Connection con=null;
	List<StudentBean> lsactual=null;
	@BeforeAll
	static void  initializer()
	{
		student=new StudentInfoServiceImpl();
		db=new DBManager();
	}
     
	@Ignore
	void test2() throws Exception
	{   lsactual =student.getAllStudentDetails(DBManager.getConnection());
	StudentBean s= lsactual.get(1);
	String name=null;
	String batch=null;
	String coreSkill=null;
	String mentor=null;
	String status=null;
//		name=s.getName();
//		batch=s.getBatch();
//		coreSkill=s.getCoreSkill();
//		mentor=s.getMentor();
//		status=s.getStatus();
//		
//		assertNotNull(name);
//		assertNotNull(batch);
//		assertNotNull(coreSkill);
//		assertNotNull(mentor);
//		assertNotNull(status);
		
		
	}

}
