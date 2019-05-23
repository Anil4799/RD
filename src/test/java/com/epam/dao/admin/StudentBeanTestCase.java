package com.epam.dao.admin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentBeanTestCase {
	
	StudentBean student;
	
	@BeforeEach
	void setup()
	{
		student=new StudentBean();
		
	}

	@Test
	void testGetFirstName() {
		student.setFirstName("demo");
		assertEquals("demo", student.getFirstName());
	}

	

	@Test
	void testGetLastName() {
		student.setLastName("demo");
		assertEquals("demo", student.getLastName());
	}

	

	@Test
	void testGetDob() {
		student.setDob(new Date());
		assertEquals(new Date(), student.getDob());
	}

	

	@Test
	void testGetEmail() {
		student.setEmail("demo@demo.com");
		assertEquals("demo@demo.com", student.getEmail());
	}

	

	@Test
	void testGetGender() {
		student.setGender("demo");
		assertEquals("demo", student.getGender());
	}

	

	@Test
	void testGetContactNumber() {
		student.setContactNumber(123456789);
		assertEquals(123456789, student.getContactNumber());
	}

	

	@Test
	void testGetPersonalLocation() {
		student.setPersonalLocation("demo");
		assertEquals("demo", student.getPersonalLocation());
	}

	

	@Test
	void testGetCollegeName() {
		student.setCollegeName("demo");
		assertEquals("demo", student.getCollegeName());
	}

	

	@Test
	void testGetCollegeLocation() {
		student.setCollegeLocation("demo");
		assertEquals("demo", student.getCollegeLocation());
	}

	

	@Test
	void testGetGraduation() {
		student.setGraduation("demo");
		assertEquals("demo", student.getGraduation());
	}

	

	@Test
	void testGetGraduationSpeciality() {
		student.setGraduationSpeciality("demo");
		assertEquals("demo", student.getGraduationSpeciality());
	}

	

	@Test
	void testGetYearOfPassedOut() {
		student.setYearOfPassedOut(2018);
		assertEquals(2018, student.getYearOfPassedOut());
	}


	@Test
	void testGetGraduationMarks() {
		student.setGraduationMarks(22);
		assertEquals(22, student.getGraduationMarks());
	}


	@Test
	void testGetTwelveth() {
		student.setTwelveth(11);
		assertEquals(11, student.getTwelveth());
	}

	@Test
	void testGetTenth() {
		student.setTenth(10);
		assertEquals(10, student.getTenth());
	}

	@Test
	void testGetBatchId() {
		student.setBatchId("RD-Q1-2019-B1");
		assertEquals("RD-Q1-2019-B1", student.getBatchId());
	}


	@Test
	void testGetEmployeeType() {
		student.setEmployeeType("demo");
		assertEquals("demo", student.getEmployeeType());
	}

	@Test
	void testGetCoreSkill() {
		student.setCoreSkill("demo");
		assertEquals("demo", student.getCoreSkill());
	}

	@Test
	void testGetPreferredStudentStream() {
		student.setPreferredStudentStream("demo");
		assertEquals("demo", student.getPreferredStudentStream());
	}

	@Test
	void testGetAssignedStream() {
		student.setAssignedStream("demo");
		assertEquals("demo", student.getAssignedStream());
	}

	@Test
	void testGetDateOfJoining() {
		student.setDateOfJoining(new Date());
		assertEquals(new Date(), student.getDateOfJoining());
	}

	@Test
	void testGetMentorName() {
		student.setMentorName("demo");
		assertEquals("demo", student.getMentorName());
	}


	@Test
	void testGetAssignedLocation() {
		student.setAssignedLocation("demo");
		assertEquals("demo", student.getAssignedLocation());
	}

	@Test
	void testGetRelocation() {
		student.setRelocation("Yes");
		assertEquals("Yes", student.getRelocation());
	}


	@Test
	void testGetStatus() {
		student.setStatus("Active");
		assertEquals("Active", student.getStatus());
	}


}
