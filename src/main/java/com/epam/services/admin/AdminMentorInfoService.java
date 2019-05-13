package com.epam.services.admin;

import java.sql.Connection;
import java.util.List;

import com.epam.dao.admin.AdminMentor;


public interface AdminMentorInfoService {
	public List<AdminMentor> getAllMentorDetails(Connection con);
}
