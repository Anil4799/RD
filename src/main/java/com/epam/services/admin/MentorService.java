package com.epam.services.admin;


import org.apache.log4j.Logger;

import com.epam.dao.admin.MentorBean;
import com.epam.dao.admin.MentorDAO;

public class MentorService {
	private static final Logger LOGGER = Logger.getLogger(MentorService.class);


	public String addMentor(MentorBean mentor)
	{
		String result="";
		try {
			if(mentor==null||mentor.getEmail()==null||mentor.getName()==null||mentor.getMentorStartDate()==null||mentor.getMentorEndDate()==null||mentor.getMaxNoOfMentees()<0||mentor.getStatus()==null||mentor.getTechnologyStream()==null)
			{
				result= "invalid";	
			}
			else
			{
				MentorDAO mdao=new MentorDAO();
				mdao.createMentor(mentor);
				result= "success";
			}
			
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
		}
		return result;
	}	
		
	
	}
		
		
		
		
	

	

