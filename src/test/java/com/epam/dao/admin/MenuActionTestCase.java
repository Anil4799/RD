package com.epam.dao.admin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenuActionTestCase {
	
	MenuAction menuAction;
	
	@BeforeEach
	void setup()
	{
		menuAction=new MenuAction();
		
	}

	@Test
	void testGetRole() {
		menuAction.setRole(123);
		assertEquals(123, menuAction.getRole());
	}


	@Test
	void testGetAction() {
		menuAction.setAction("View");
		assertEquals("View", menuAction.getAction());
	}

	@Test
	void testGetStatusName() {
		menuAction.setStatusName("active");
		assertEquals("active", menuAction.getStatusName());
	}


}
