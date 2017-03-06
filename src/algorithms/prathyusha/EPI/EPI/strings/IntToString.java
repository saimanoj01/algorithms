package strings;

public class IntToString {
	public static void main(String[] args) {
		String intString = "+123" ;
		int intNumber = 0;
		int index = intString.length() - 1 , power = 1;
		for ( ; index >= 0 ; index--) {
			if ( index == 0 && intString.charAt(index) == '-' ) {
				intNumber = ( -1 ) * intNumber;
			}
			else if ( index == 0 && intString.charAt(index) == '+' ) {
				
			}
			else if ( intString.charAt(index) != 0 ) {
				intNumber = intNumber + ( intString.charAt(index) - (int) '0' ) * power;
				power = power * 10;
			}
		}
		System.out.println((18278-26)%26);
		System.out.println( intNumber );
	}
}
