package utils;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Equation implements Calculate, Serializable {
	private static final long serialVersionUID = 1L;
	
	private String equation;
	private int length;
	private int numberOfOperators;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = 1;
		while (x != 0) {
			Equation e = new Equation();
			System.out.println(e.length + " uzunluklu ve " + e.numberOfOperators + " adet iþaretli:");
			System.out.println(e.equation);
			x = in.nextInt();
		}
		in.close();
	}
	
	public Equation() {
		Random random = new Random();
		int r = 9 - 7 + 1;
		length = random.nextInt(r) + 7;
		
		numberOfOperators = random.nextInt((length + 1) / 3) + 1;
		
		int[] bounds = {10, 100, 1000};
		char[] operators = {'+', '-', '*', '/'};
		String e = "";
		for (int i = 0; i <= numberOfOperators; i++) {
			e += random.nextInt(bounds[i]);
			if (i != numberOfOperators) {
				char chosenOperator = operators[random.nextInt(4)];
				e += chosenOperator;
			}
		}
		
		equation = e;
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
	
	public String generateEquation() {
		
		
		return "";
	}
}
