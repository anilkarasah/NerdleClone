package utils;

import java.util.Stack;

public class Calculate {
	
	/********************************************************/
	/*               SOURCE OF  THESE METHODS               */
	/* https://www.geeksforgeeks.org/expression-evaluation/ */
	/********************************************************/
	
	public static int calculate(String equation) {
		char[] tokens = equation.toCharArray();
		Stack<Integer> numberS = new Stack<Integer>();
		Stack<Character> symbolS = new Stack<Character>();
		
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sbuf = new StringBuffer();
				
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sbuf.append(tokens[i++]);
				
				numberS.push(Integer.parseInt(sbuf.toString()));
				i--;
			} else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
				while (!symbolS.empty() && hasPrecedence(tokens[i], symbolS.peek()))
					numberS.push(applyOp(symbolS.pop(), numberS.pop(), numberS.pop()));
				
				symbolS.push(tokens[i]);
			}
		}
		
		while (!symbolS.empty())
			numberS.push(applyOp(symbolS.pop(), numberS.pop(), numberS.pop()));
		
		return numberS.pop();
	}
	
	public static boolean hasPrecedence(char op1, char op2) {
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}
	
	public static int applyOp(char operator, int b, int a) throws ArithmeticException {
		switch(operator) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new ArithmeticException("Sýfýra bölünemez.");
			return a / b;
		}
		return 0;
	}
	
	public static String parseEquation(String e) {
		return e.split("=")[0];
	}
}
