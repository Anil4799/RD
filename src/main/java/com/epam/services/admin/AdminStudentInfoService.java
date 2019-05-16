package com.epam.services.admin;
import java.sql.Connection;
import java.util.List;
import com.epam.dao.admin.AdminStudent;

public interface AdminStudentInfoService {
	public List<AdminStudent> getAllStudentDetails(Connection con);
}