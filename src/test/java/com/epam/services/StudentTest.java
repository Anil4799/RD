package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.epam.dao.admin.AdminStudent;
import com.epam.services.admin.AdminStudentInfoServiceImpl;
import com.epam.utils.DBManager;

import jdk.nashorn.internal.ir.annotations.Ignore;

class StudentTest {
	static DBManager db;
	static AdminStudentInfoServiceImpl student;
	static Connection con=null;
	List<AdminStudent> lsactual=null;
	@BeforeAll
	static void  initializer()
	{
		student=new AdminStudentInfoServiceImpl();
		db=new DBManager();
	}
     
	@Ignore
	void Studenttest() throws Exception {
		lsactual =student.getAllStudentDetails(DBManager.getConnection());
		AdminStudent s= lsactual.get(1);
		String name=null;
		String batch=null;
		String coreSkill=null;
		String mentor=null;
		String status=null;
//			name=s.getName();
//			batch=s.getBatch();
//			coreSkill=s.getCoreSkill();
//			mentor=s.getMentor();
//			status=s.getStatus();
//			
//			assertNotNull(name);
//			assertNotNull(batch);
//			assertNotNull(coreSkill);
//			assertNotNull(mentor);
//			assertNotNull(status);
	}

}
