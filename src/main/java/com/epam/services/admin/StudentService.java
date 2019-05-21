package com.epam.services.admin;

import java.util.List;

import com.epam.dao.admin.CollegeBean;
import com.epam.dao.admin.StudentBean;

public interface StudentService {
	int addStudentDetails(StudentBean studentBean);
	public List<CollegeBean> getCollegNames();
	public List<String> getBatchID();
	public List<String> getEmployeeType();
	public List<String> getcoreSkill();
	public List<String> getPreferredStream();
	
	public List<String> getAssignedStream();
	public List<String> getAssignedLocation();
	public List<String> getMentor();
	public List<String> getStatus();
}
