package com.epam.services;

/**
 * The Class AdditionServiceImpl.
 *
 * @author Durga_Adimulam
 */
public class CalculatorServiceImpl implements CalculatorService {


	@Override
	public int add(int firstNumber, int secondNumber) {
		return firstNumber + secondNumber;
	}
	

}
