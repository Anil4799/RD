package com.epam.services.admin;

import java.sql.Connection;
import java.util.List;

import com.epam.dao.admin.Mentor;


public interface AdminMentorInfoService {
	public List<Mentor> getAllMentorDetails(Connection con);
}
