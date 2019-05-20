package com.epam.services.admin;

import java.util.List;

import com.epam.dao.admin.StudentBean;

public interface StudentService {
	boolean addStudentDetails(StudentBean studentBean);
	public List<String> getCollegNames();
}
