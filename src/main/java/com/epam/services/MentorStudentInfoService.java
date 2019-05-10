package com.epam.services;

import java.sql.Connection;
import java.util.List;

import com.epam.dao.MentorStudent;

public interface MentorStudentInfoService {
	public List<MentorStudent> MentorStudentDetails(Connection con);
}
