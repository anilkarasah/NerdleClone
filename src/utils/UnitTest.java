package utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitTest {
	
	String equation = new Equation().generateEquation("");

	@Test
	void hasOneEqualsSign() {
		int numberOfEqualsSign = 0;
		char[] eq = equation.toCharArray();
		
		for (int i = 0; i < eq.length; i++) {
			if (eq[i] == '=')
				numberOfEqualsSign++;
		}
		
		assertEquals(true, numberOfEqualsSign == 1);
	}

	@Test
	void hasValidLength() {
		assertEquals(true, (equation.length() == 7 || equation.length() == 8 || equation.length() == 9));
	}
	
	@Test
	void hasMoreThanOneOperator() {
		int numberOfOperators = 0;
		char[] eq = equation.toCharArray();
		
		for (int i = 0; i < eq.length; i++) {
			if (eq[i] == '+' || eq[i] == '-' || eq[i] == '*' || eq[i] == '/')
				numberOfOperators++;
		}
		
		assertEquals(true, numberOfOperators >= 1);
	}
	
	@Test
	void startsWithOperator() {
		char[] eq = equation.toCharArray();
		
		assertEquals(true, (eq[0] != '+' || eq[0] != '-' || eq[0] != '*' || eq[0] != '/'));
	}
}
