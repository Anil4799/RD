package com.epam.services.admin;

import java.sql.Connection;
import java.util.List;

import com.epam.dao.admin.Mentor;


public interface AdminMentorInfoService {
	public List<Mentor> getAllMentorDetails(Connection con);
	public List<Mentor> searchMentors(Connection con,String mentorname,String technology);
	public List<String> getTechnologyStream(Connection con);
}
