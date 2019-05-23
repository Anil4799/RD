package com.epam.services.mentor;
import java.sql.Connection;
import java.util.List;

import com.epam.dao.mentor.MentorStudent;

public interface MentorStudentInfoService {
	public List<MentorStudent> mentorStudentDetails(Connection con, String mentorEmailId);
	public List<MentorStudent> getAllSearchStudentDetails(Connection con,String mentorEmailId, String firstNamedb,String lastNamedb,String batchIDdb);
}
