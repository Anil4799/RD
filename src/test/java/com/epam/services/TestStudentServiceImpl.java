package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;


import java.sql.Date;
import org.junit.jupiter.api.Test;

import com.epam.dao.admin.StudentBean;
import com.epam.services.admin.StudentServiceImpl;

import jdk.nashorn.internal.ir.annotations.Ignore;

class TestStudentServiceImpl {
	StudentServiceImpl addstudent=null;
	StudentBean bean=null;
   
	
	@Ignore
	void test() {
		
		bean=new StudentBean();
		addstudent=new StudentServiceImpl();
		boolean check=true;
		check=addstudent.addStudentDetails(bean);
		assertEquals(true, check);
	
	}
	
	
}
