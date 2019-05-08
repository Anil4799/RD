/**
 * 
 */
package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @author Durga_Adimulam
 *
 */
class TestCalculatorServiceImpl {
	
	@InjectMocks
	private CalculatorServiceImpl calculatorService;

	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testAdd() {
		assertEquals(3, calculatorService.add(1, 2));
		
	}

}
