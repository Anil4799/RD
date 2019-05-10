package com.epam.services;

import java.sql.Connection;
import java.util.List;

import com.epam.dao.Batch;

public interface BatchInfoService {
	
	public List<Batch> getAllBatchsList(Connection con);

}
