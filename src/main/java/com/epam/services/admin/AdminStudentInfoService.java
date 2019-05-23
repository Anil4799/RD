package com.epam.services.admin;
import java.sql.Connection;
import java.util.List;
import com.epam.dao.admin.Student;
import com.epam.dao.admin.StudentBean;

public interface AdminStudentInfoService {
	public List<Student> getAllStudentDetails(Connection con);
	public List<Student> getAllSearchStudentDetails(Connection con,String firstNamedb,String lastNamedb,String batchID);
	public List<StudentBean> adminStudentDetails(Connection con, String studentEmailId);
}