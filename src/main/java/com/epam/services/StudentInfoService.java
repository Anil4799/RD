package com.epam.services;

import java.sql.Connection;
import java.util.List;

import com.epam.dao.Student;

public interface StudentInfoService {
	public List<Student> getAllStudentDetails(Connection con);
}