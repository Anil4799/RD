package com.epam.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.epam.services.login.LoginServiceImp;

public class TestLoginServiceImp {
	@InjectMocks
	private LoginServiceImp loginServiceImp;

	@BeforeEach
	void init() {
		loginServiceImp = new LoginServiceImp();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testlogin1() {
		assertEquals(1, loginServiceImp.login("test_admin1@epam.com","testadmin"));
		
	}
	
	@Test
	void testlogin2() {
		assertEquals(2, loginServiceImp.login("test_mentor1@epam.com","testmentor"));
		
	}
	
	@Test
	void testloginError() {
		assertEquals(0, loginServiceImp.login("test_mentor1@epam.com","testmentor123"));
	}
	
	@Test
	void testloginEmpty() {
		assertEquals(0, loginServiceImp.login("",""));
	}
	
}
