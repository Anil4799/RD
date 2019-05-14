package com.epam.student.service;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Beans;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.student.beans.StudentBean;
import com.epam.student.services.StudentServiceImpl;

class TestStudentServiceImpl {
	StudentServiceImpl addstudent=null;
	StudentBean bean=null;
   
	
	@Test
	void test() {
		bean=new StudentBean("vijay", "a", Date.valueOf("2019-05-05"), "dddd", "v", 0,"f", "g", "h", "i", "j", 0, 0, 0, 0, "k", "l", "m", "n", "o", Date.valueOf("2019-05-05"), "q", "r", "s", "t");
		addstudent=new StudentServiceImpl();
		boolean check=true;
		check=addstudent.addStudentDetails(bean);
		assertEquals(true, check);
	
	}
	/*
	 * @Test void testget() { String firstName=null; String lastName=null; Date
	 * dob=null; String email=null; String gender=null; long contactNumber=0; String
	 * personalLocation=null; String collegeName=null; String collegeLocation=null;
	 * String graduation=null; String graduationSpeciality=null; int
	 * yearOfPassedOut=0; int graduationMarks=0; int twelveth=0; int tenth=0; String
	 * batchId=null; String employeeType=null; String coreSkill=null; String
	 * preferredStudentStream=null; String assignedStream=null; //Date
	 * dateOfJoining=null; String mentorName=null; String assignedLocation=null;
	 * String relocation=null; String status=null; firstName=bean.getFirstName();
	 * lastName=bean.getLastName(); dob=bean.getDob(); email=bean.getEmail();
	 * gender=bean.getGender(); contactNumber=bean.getContactNumber();
	 * personalLocation=bean.getPersonalLocation();
	 * collegeName=bean.getCollegeName(); collegeLocation=bean.getCollegeLocation();
	 * graduation=bean.getGraduation();
	 * graduationSpeciality=bean.getGraduationSpeciality();
	 * yearOfPassedOut=bean.getYearOfPassedOut();
	 * graduationMarks=bean.getGraduationMarks(); twelveth=bean.getTwelveth();
	 * tenth=bean.getTenth(); batchId=bean.getBatchId();
	 * employeeType=bean.getEmployeeType(); coreSkill=bean.getCoreSkill();
	 * preferredStudentStream=bean.getPreferredStudentStream();
	 * assignedStream=bean.getAssignedStream(); mentorName=bean.getMentorName();
	 * assignedLocation=bean.getAssignedLocation(); relocation=bean.getRelocation();
	 * status=bean.getStatus(); assertNotNull(firstName); assertNotNull(lastName);
	 * assertNotNull(email); assertNotNull(gender); assertNotNull(firstName);
	 * assertNotNull(contactNumber); assertNotNull(personalLocation);
	 * assertNotNull(collegeName); assertNotNull(collegeLocation);
	 * assertNotNull(graduation); assertNotNull(graduationSpeciality);
	 * assertNotNull(yearOfPassedOut); assertNotNull(graduationMarks);
	 * assertNotNull(twelveth); assertNotNull(tenth); assertNotNull(batchId);
	 * assertNotNull(employeeType); assertNotNull(coreSkill);
	 * assertNotNull(preferredStudentStream); assertNotNull(assignedStream);
	 * assertNotNull(mentorName); assertNotNull(assignedLocation);
	 * assertNotNull(relocation); assertNotNull(status);
	 * 
	 * }
	 */

}
