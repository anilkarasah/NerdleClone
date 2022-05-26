package utils;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String nextEq = input.nextLine();
		input.close();

		Equation eq = new Equation(nextEq, 8, 3);
		
		// 7+9/3=10
		
		eq.calculate();
	}

}
