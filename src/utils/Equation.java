package utils;

import java.util.regex.*;

public class Equation implements Calculate {
	private String equation;
	private int length;
	private int numberOfOperators;
	
	public Equation(String equation, int length, int numberOfOperators) {
		super();
		this.equation = equation;
		this.length = length;
		this.numberOfOperators = numberOfOperators;
	}

	public int calculate() {
		System.out.println(equation);
		String[] tokens = equation.split("[*+/=-]");
		
		for (String s : tokens)
			System.out.println(s);
		
		return 0;
	}
}
