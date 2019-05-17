package com.epam.services.admin;

import java.sql.Connection;
import java.util.List;

import com.epam.dao.admin.AdminBatch;


public interface AdminBatchInfoService {
	
	public List<AdminBatch> getAllBatchsList(Connection con);

}
