package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.epam.dao.batch.BatchInfoDAOImpl;

class TestBachInfoDAOImp {
  
	BatchInfoDAOImpl batchindodao=new BatchInfoDAOImpl();
	
	@Test
	void test() throws Exception {
     String result="Batch Saved successfully";
     String actual=batchindodao.saveBatchInfo(1, "RD-Q1-2020-B1",2020, "abc", "2019-07-07","2019-06-06", "string");
     assertEquals(result, actual);
	}

	
}
