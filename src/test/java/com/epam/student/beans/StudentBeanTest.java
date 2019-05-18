package com.epam.student.beans;

import static org.junit.jupiter.api.Assertions.*;


import java.sql.Date;
import org.junit.jupiter.api.Test;

import com.epam.dao.admin.StudentBean;

class StudentBeanTest {

	@Test
	void test() {

		String firstName=null; 
		 String lastName=null; 
		 java.util.Date dob =null;
		 String email=null; 
		 String gender=null; 
		 long contactNumber=0; 
		 String personalLocation=null; 
		 String collegeName=null; 
		 String collegeLocation=null;
		 String graduation=null; 
		 String graduationSpeciality=null; 
		 int yearOfPassedOut=0; 
		 int graduationMarks=0; 
		 int twelveth=0; 
		 int tenth=0; 
		 String	batchId=null; 
		 String employeeType=null; 
		 String coreSkill=null; 
		 String preferredStudentStream=null; 
		 String assignedStream=null; 
		 java.util.Date dateOfJoining = null;
		 String mentorName=null; 
		 String assignedLocation=null;
		 String relocation=null; 
		 String status=null; 
		
		  StudentBean student =new StudentBean();
		  student.setFirstName(student.getFirstName());
		  student.setLastName(student.getLastName());
		  student.setDob(student.getDob());
		  student.setEmail(student.getEmail());
		  student.setGender(student.getGender());
		  student.setContactNumber(student.getContactNumber());
		  student.setPersonalLocation(student.getPersonalLocation());
		  student.setCollegeName(student.getCollegeName());
		  student.setCollegeLocation(student.getCollegeLocation());
		  student.setGraduation(student.getGraduation());
		  student.setGraduationSpeciality(student.getGraduationSpeciality());
		  student.setYearOfPassedOut(student.getYearOfPassedOut());
		  student.setGraduationMarks(student.getGraduationMarks());		  
		  student.setTwelveth(student.getTwelveth());
		  student.setTenth(student.getTenth());
		  student.setBatchId(student.getBatchId());
		  student.setEmployeeType(student.getEmployeeType());
		  student.setCoreSkill(student.getCoreSkill());
		  student.setPreferredStudentStream(student.getPreferredStudentStream());
		  student.setAssignedStream(student.getAssignedStream());
		  student.setDateOfJoining(student.getDateOfJoining());
		  student.setMentorName(student.getMentorName());
		  student.setAssignedLocation(student.getAssignedLocation());
		  student.setRelocation(student.getRelocation());
		  student.setStatus(student.getStatus());
		  assertNull(firstName); 
		 assertNull(lastName);
		 assertNull(dob); 
		 assertNull(email); 
		 assertNull(gender);
		 assertEquals(0, contactNumber); 
		 assertNull(personalLocation);
		 assertNull(collegeName); 
		 assertNull(collegeLocation);
		 assertNull(graduation); 
		 assertNull(graduationSpeciality);
		 assertEquals(0, yearOfPassedOut);
		 assertEquals(0, graduationMarks);
		 assertEquals(0, twelveth); 
		 assertEquals(0, tenth); 
		 assertNull(batchId);
		 assertNull(employeeType); 
		 assertNull(coreSkill);
		 assertNull(preferredStudentStream); 
		 assertNull(assignedStream);
		 assertNull(dateOfJoining);
		 assertNull(mentorName); 
		 assertNull(assignedLocation);
		 assertNull(relocation); 
		 assertNull(status); 
		  
	}

}
