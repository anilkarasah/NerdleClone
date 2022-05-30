package utils;

import java.io.Serializable;
import java.util.Random;

public class Equation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String equation;
	private int length;
	private int numberOfOperators;
	
	public static void main(String[] args) {
		Equation e = new Equation();
		String temp;
		System.out.println("Uzunluk: " + e.getLength());
		temp = e.generateEquation("");
		System.out.println(temp);
	}
	
	public Equation() {
		Random random = new Random();
		int r = 9 - 7 + 1;
		length = random.nextInt(r) + 7;
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
		
		if (temp.length() != this.length)
			return generateEquation("");
		
		return temp;
	}
	
	public int validDivider(int numerator) {
		Integer[] dividers = new Integer[numerator];
		int next = 0;
		for (int i = 1; i <= numerator; i++) {
			if (numerator / i == (double)numerator / i) {
				dividers[next++] = i;
			}
		}
		
		return dividers[new Random().nextInt(next)];
	}
}
