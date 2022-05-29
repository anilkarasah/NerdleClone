package utils;

import java.io.Serializable;

public class Equation implements Calculate, Serializable {
	private static final long serialVersionUID = 1L;
	
	private String equation;
	private int length;
	private int numberOfOperators;
	
	public Equation(String equation, int length, int numberOfOperators) {
		this.equation = equation;
		this.length = length;
		this.numberOfOperators = numberOfOperators;
	}
	
	public String getEquation() { return this.equation; }
	public int getLength() { return this.length; }
	public int getOperatorAmount() { return this.numberOfOperators; }

	public int calculate() {
		System.out.println(equation);
		String[] tokens = equation.split("[*+/=-]");
		
		for (String s : tokens)
			System.out.println(s);
		
		return 0;
	}
}
