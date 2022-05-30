package utils;

import java.io.Serializable;
import java.util.Random;

public class Equation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String equation;
	private int length;
	private int numberOfOperators;
	
	public Equation() {
		Random random = new Random();
		length = random.nextInt(3) + 7;
	}
	
	public String getEquation() { return this.equation; }
	public int getLength() { return this.length; }
	public int getOperatorAmount() { return this.numberOfOperators; }
	
	public void setEquation(String equation) { this.equation = equation; }
	
	public String generateEquation(String current) {
		Random random = new Random();
		System.out.println(current);
		char[] ops = {'+', '-', '/', '*'};
		int prevRandomNumber = random.nextInt(100);
		
		if (current.isEmpty())
			current = "" + prevRandomNumber;
		
		String temp;
		do {
			char randomOp = ops[random.nextInt(4)];
			current += randomOp;
			int tmp;
			if (randomOp == '/') {
				tmp = validDivider(prevRandomNumber);
			} else if (randomOp == '*')
				tmp = random.nextInt(20);
			else
				tmp = random.nextInt(100);

			prevRandomNumber = tmp;
			current += "" + tmp;
			temp = current + "=" + Calculate.calculate(current);
		} while (temp.length() < this.length);
		
		if (temp.length() != this.length || Calculate.calculate(current) < 0)
			return generateEquation("");
		
		return temp;
	}
	
	public int validDivider(int numerator) {
		Integer[] dividers = new Integer[numerator + 1];
		dividers[0] = 1;
		int next = 1;
		for (int i = 2; i <= numerator; i++) {
			// Check if the numerator is divisible by 'i' without carry
			if (numerator / i == (double)numerator / i) {
				dividers[next++] = i;
			}
		}
		
		return dividers[new Random().nextInt(next)];
	}
}
