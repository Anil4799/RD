package com.epam.services.mentor;


import com.epam.dao.mentor.MentorDAO;
import com.epam.mentor.bean.MentorBean;

public class MentorService {

	public String addMentor(MentorBean mentor) throws Exception
	{
		
		if(mentor==null||mentor.getEmail()==null||mentor.getName()==null||mentor.getMentorStartDate()==null||mentor.getMentorEndDate()==null||mentor.getMaxNoOfMentees()<0||mentor.getStatus()==null||mentor.getTechnologyStream()==null)
		{
		return "invalid";	
		
		}
		MentorDAO mdao=new MentorDAO();
		mdao.createMentor(mentor);
		return "success";
		
		
		
	}	
		
	
	}
		
		
		
		
	

	

