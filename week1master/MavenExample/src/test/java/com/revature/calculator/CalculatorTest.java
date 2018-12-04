package com.revature.calculator;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	private static Logger log = null;
	private static Calculator<Double> doubCalc = null;
	//before the tests
	@BeforeClass
	public static void setup2() {
		log = Logger.getLogger(CalculatorTest.class);
		log.trace("before tests run");
	}
	//before each test
	@Before
	public void setup() {
		log.trace("Setting up tests");
		doubCalc = new Calculator<Double>();
	}
	//after each test
	@After
	public void teardown() {
		log.trace("tearing down the test (closing resources and such)");
	}
	@AfterClass
	public static void tearAll() {
		log.trace("tearing everything down");
	}
	@Test
	public void multiplicationOfZeroReturnsZero() {
		log.trace("Testing if multiplication of zero results in zero.");
		assertEquals("Test if 5*0 = 0", new Double(0.0), doubCalc.mult(5.0, 0.0));
	}
	@Test
	public void divideByZeroEqualsInfinity() {
		log.trace("Testing if division by zero results in infinity.");
		assertEquals("Test if 5/0 = infinity", new Double(Double.POSITIVE_INFINITY), doubCalc.div(5.0, 0.0));
	}
}
