package com.epam.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.epam.dao.admin.MentorBean;
import com.epam.services.admin.MentorService;

import jdk.nashorn.internal.ir.annotations.Ignore;


public class MentorServiceTest {

	static MentorService ms;
	@BeforeAll
	public static void instantiation()
	{
		ms = new MentorService();
	}
	
	@Ignore
	public void Testsucess() throws Exception {
		String s="12-11-2019";
		SimpleDateFormat sdf=new SimpleDateFormat("MM-DD-YYYY");
		Date d=sdf.parse(s);
		MentorBean mb = new MentorBean();
		mb.setName("chaitu");
		mb.setEmail("z3dyyl@yahoo.com");
		mb.setMaxNoOfMentees(5); 
		mb.setMentorEndDate(d);
		mb.setMentorStartDate(d);
		mb.setStatus("Active");
		mb.setTechnologyStream("cse");
		assertEquals("success",ms.addMentor(mb));
	}

	

	
	
	
	
	@Test
	public void TestInsertInvalidNull() throws Exception {
		String s="12-11-2019";
		SimpleDateFormat sdf=new SimpleDateFormat("MM-DD-YYYY");
		Date d=sdf.parse(s);
		MentorBean mb = new MentorBean();
		mb.setName("chaitu");
		mb.setEmail("z211@yahoo.com");
		mb.setMaxNoOfMentees(5); 
		mb.setMentorEndDate(d);
		mb.setMentorStartDate(d);
		mb.setStatus(null);
		mb.setTechnologyStream("java");
		assertEquals("invalid",ms.addMentor(mb));
	}
	
}
