package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.utils.DBManager;

import jdk.nashorn.internal.ir.annotations.Ignore;

class MenuActionItemServiceTestCase {
	
	MenuActionItemService menuActionItemService=null;
	
	@InjectMocks private DBManager dbConnection;
	  @Mock private Connection mockConnection;
	  @Mock private Statement mockStatement;
	  
	  @BeforeEach
	  public void setUp() {
	    MockitoAnnotations.initMocks(this);
	  }
	
	
	@BeforeEach
	void setuo()
	{
		menuActionItemService = new MenuActionItemServiceImpl();
	}

	@Ignore
	void testGetMenuActionList() {
		//Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
	   // Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
	    //int value = dbConnection.executeQuery("");
	    //assertEquals(value, 1);
	   // Mockito.verify(mockConnection.createStatement(), Mockito.times(1));
		//menuActionItemService.getMenuActionList(con, role);
	}

}
