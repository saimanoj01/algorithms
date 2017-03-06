package stacks;

import java.util.Stack;

public class BalancedParanthesis {
	public static void main(String[] args) {
		String paren = "((()(()))(" ;
		Stack<Character> parenStack = new Stack<Character>();
		for ( int index = 0; index<paren.length(); index++) {
			if ( paren.charAt(index) == '(' ) {
				parenStack.push(paren.charAt(index));
			}
			else {
				parenStack.pop();
			}
		}
		if (parenStack.isEmpty()) {
			System.out.println("Balanced");
		}
		else {
			System.out.println("Not Balanced");
		}
	}
}
