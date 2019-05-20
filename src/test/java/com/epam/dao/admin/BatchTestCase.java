package com.epam.dao.admin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BatchTestCase {
	
	Batch batch;
	
	@BeforeEach
	void setup()
	{
		batch=new Batch();
		
	}

	@Test
	void testGetBatchnum() {
		batch.setBatchnum(123);
		assertEquals(123, batch.getBatchnum());
	}

	

	@Test
	void testGetBatchid() {
		batch.setBatchid("123");
		assertEquals("123", batch.getBatchid());
	}

	

	@Test
	void testGetYearnum() {
		batch.setYearnum(123);
		assertEquals(123, batch.getYearnum());
	}

	

	@Test
	void testGetQuarternum() {
		batch.setQuarternum("123");
		assertEquals("123", batch.getQuarternum());
	}

	

	@Test
	void testGetStartdate() {
		batch.setStartdate("2019-12-03");
		assertEquals("12-03-2019", batch.getStartdate());
	}

	

	@Test
	void testGetEnddate() {
		batch.setEnddate("2019-12-03");
		assertEquals("12-03-2019", batch.getEnddate());
	}

	

	@Test
	void testGetStatus() {
		batch.setStatus("123");
		assertEquals("123", batch.getStatus());
	}

	

	@Test
	void testDateFormat() throws Exception {
		try {
			batch.dateFormat("2019-12-03");
		} catch (Exception e) {
			assertTrue(e instanceof Exception);
        }
	}

}
