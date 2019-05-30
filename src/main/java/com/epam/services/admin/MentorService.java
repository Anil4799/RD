package com.epam.services.admin;


import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.epam.dao.admin.MentorBean;
import com.epam.dao.admin.MentorDAO;

public class MentorService {
	private static final Logger LOGGER = Logger.getLogger(MentorService.class);
	private static final String ERROR="invalid";

	public String addMentor(MentorBean mentor)
	{
		String result="";
		try {
			if(mentor==null||mentor.getEmail()==null||mentor.getName()==null||mentor.getMentorStartDate()==null||mentor.getMaxNoOfMentees()<0||mentor.getStatus()==null||mentor.getTechnologyStream()==null)
			{
				result= ERROR;	
			}
			else
			{
				
				MentorDAO mdao=new MentorDAO();
				int value=mdao.createMentor(mentor);
				if(value>0)
				{
					result= "success";
				}
				else{
					result = ERROR;
				}
			}
			
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
		}
		return result;
	}	
		
	
	public MentorBean viewMentor(String id) 
	{
		MentorBean mentor=new MentorBean();
		MentorDAO mdao=new MentorDAO();
		try {
			mentor=mdao.viewMentor(id);
		} catch (SQLException e) {
			LOGGER.debug(e.getMessage());
		}
		
		
		return mentor;
		
	}


	public String updateMentor(MentorBean mentor)
	{
		String result="";
		try {
			if(mentor==null||mentor.getEmail()==null||mentor.getName()==null||mentor.getMentorStartDate()==null||mentor.getMaxNoOfMentees()<0||mentor.getStatus()==null||mentor.getTechnologyStream()==null)
			{
				result= ERROR;	
			}
			else
			{
				MentorDAO mdao=new MentorDAO();
				mdao.updateMentor(mentor);
				result= "success";
			}
			
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
		}
		return result;
	}	
	
	
	
	
	
	}
		
		
		
		
	

	

