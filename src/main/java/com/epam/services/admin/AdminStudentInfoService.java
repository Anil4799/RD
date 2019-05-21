package com.epam.services.admin;
import java.sql.Connection;
import java.util.List;
import com.epam.dao.admin.Student;

public interface AdminStudentInfoService {
	public List<Student> getAllStudentDetails(Connection con);
}