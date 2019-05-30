package com.epam.common.servlet;

import java.sql.Connection;
import java.util.List;
import com.epam.dao.admin.StudentBean;

public interface StudentInfoService {
	public List<StudentBean> getAllStudentDetails(Connection con);
	public List<StudentBean> getAllSearchStudentDetails(Connection con,String firstNamedb,String lastNamedb,String batchID);
	public List<StudentBean> adminStudentDetails(Connection con, String studentEmailId);
	List<StudentBean> mentorStudentDetails(Connection con, String mentorEmailId);
	List<StudentBean> getAllSearchStudentDetails(Connection con, String mentorEmailId, String firstNamedb,
			String lastNamedb, String batchIDdb);
	List<StudentBean> mentorViewStudentDetails(Connection con, String emailId);
}