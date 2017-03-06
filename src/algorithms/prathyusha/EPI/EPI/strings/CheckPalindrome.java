package strings;

public class CheckPalindrome {
	public static void main(String[] args) {
		String name = "ABBC";
		int head = 0, tail = name.length() - 1;
		boolean flag = true;
		while ( head < tail ) { // check each character and its corresponding char from end till the head just reaches tail
			if ( name.charAt(head) != name.charAt(tail)) {
				flag = false;
				break;
			}
			else{
				head++;
				tail--;
			}
		}
		if ( flag == true ) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not palindrome");
		}
	}
}
