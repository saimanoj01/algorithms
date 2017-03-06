package stacks;

import java.util.Stack;

public class Fidessa_MatchingPairs {
  /* To find matching pairs in a input  */
	public static void main(String[] args) {
		System.out.println(findMatchingPair("ABbaXx"));
	}
	
	static int findMatchingPair ( String input ) {
		int i = 0, index = -1;
		if ( input == null || input == "") {
			return -1;
		}
		else {
			Stack<Character> stack = new Stack<Character>();
			for ( i = 0; i < input.length(); i++ ) {
				char ch = input.charAt(i);
				if (Character.isUpperCase(ch)) {
					stack.push(ch);
				}
				else if (!stack.isEmpty() &&  Character.toLowerCase(stack.pop()) == ch ) {
						index = i;
				}
				else break;
			}
		}
		return index;
	}
	
}
