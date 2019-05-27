package com.epam.services.admin;
import java.sql.Connection;
import java.util.List;

import com.epam.dao.admin.StudentBean;

public interface ViewStudentInfoService {
	public List<StudentBean> adminStudentDetails(Connection con);
}
