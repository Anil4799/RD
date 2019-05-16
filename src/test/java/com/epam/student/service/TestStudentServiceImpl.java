package com.epam.student.service;

import static org.junit.jupiter.api.Assertions.*;


import java.sql.Date;
import org.junit.jupiter.api.Test;

import com.epam.student.beans.StudentBean;
import com.epam.student.services.StudentServiceImpl;

import jdk.nashorn.internal.ir.annotations.Ignore;

class TestStudentServiceImpl {
	StudentServiceImpl addstudent=null;
	StudentBean bean=null;
   
	
	@Test
	void test() {
		
		bean=new StudentBean("Vanshita", "Baweja", Date.valueOf("2009-05-05"), "rfgh12345@gmail.com", "female", 98765,"Chandigarh", "Chitkara", "Chandigarh", "BE", "CSE", 2013, 100, 100, 100, "RD-Q1-2019-B1", "FTE", "Java", "Java", "Java", Date.valueOf("2019-04-30"), "Durga", "Hyderabad", "Yes", "Active");
		addstudent=new StudentServiceImpl();
		boolean check=true;
		check=addstudent.addStudentDetails(bean);
		assertEquals(true, check);
	
	}
	
	
}
