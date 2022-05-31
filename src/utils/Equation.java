package utils;

import java.io.Serializable;
import java.util.Random;

public class Equation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String equation;
	private int length;
	private int[] correctness;
	
	public Equation() {
		Random random = new Random();
		this.length = random.nextInt(3) + 7;
		this.correctness = new int[length];
		for (int i = 0; i < length; i++)
			correctness[i] = 0;
	}
	
	public Equation(String guess, int length) {
		this.equation = guess;
		this.length = length;
		correctness = new int[length];
	}
	
	public String getEquation() { return this.equation; }
	public int getLength() { return this.length; }
	public int[] getCorrectness() { return this.correctness; }
	public int getCorrectness(int index) { return this.correctness[index]; }
	
	public void setEquation(String equation) { this.equation = equation; }
	
	public String generateEquation(String current) {
		Random random = new Random();
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
			// Check if the numerator is divisible by 'i'
			if (numerator / i == (double)numerator / i) {
				dividers[next++] = i;
			}
		}
		
		return dividers[new Random().nextInt(next)];
	}
	
	public boolean checkForCorrectness(String realEquation) {
		char[] eq = this.equation.toCharArray();

		// Mark correct characters with correct place
		for (int i = 0; i < this.length; i++)
			if (eq[i] == realEquation.charAt(i))
				correctness[i] = 1;
		
		// Mark correct characters with another place
		for (int i = 0; i < this.length; i++) {
			if (correctness[i] == 1) continue;
			
			for (int j = 0; j < this.length; j++) {
				if (correctness[j] == 1) continue;
				
				if (eq[i] == realEquation.charAt(j) && correctness[j] == 0)
					correctness[i] = 2;
			}
		}
		
		// Mark wrong characters
		for (int i = 0; i < this.length; i++)
			if (correctness[i] == 0)
				correctness[i] = -1;
		
		int i = 0;
		while (i < length && correctness[i] == 1) i++;
		
		if (i == length) return true;
		else return false;
	}
}
