package com.epam.services.mentor;
import java.sql.Connection;
import java.util.List;
import com.epam.dao.mentor.MentorStudent;

public interface MentorStudentInfoService {
	public List<MentorStudent> mentorStudentDetails(Connection con, String mentorEmailId);
	public List<MentorStudent> mentorViewStudentDetails(Connection con, String emailId);
	
}
