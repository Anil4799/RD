package com.epam.services;

import java.sql.Connection;
import java.util.List;

import com.epam.dao.Mentor;


public interface MentorInfoService {
	public List<Mentor> getAllMentorDetails(Connection con);
}
