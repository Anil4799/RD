package com.epam.services.mentor;


import java.sql.SQLException;

import com.epam.dao.mentor.MentorDAO;
import com.epam.mentor.bean.MentorBean;

public class MentorService {

	public String addMentor(MentorBean mentor) throws Exception
	{
		int addmentor=0;
		if(mentor==null||mentor.getEmail()==null||mentor.getName()==null||mentor.getMentorStartDate()==null||mentor.getMentorEndDate()==null||mentor.getMaxNoOfMentees()<0||mentor.getStatus()==null)
		{
		return "invalid";	
		
		}
		MentorDAO mdao=new MentorDAO();
		addmentor=mdao.createMentor(mentor);
		return "success";
		
		
		
	}	
		
	
	}
		
		
		
		
	

	

