package string;

public class ReverseAString {
	public static void main(String[] args) {
		String  name = "Prathyusha" ;
		char[] reverse = new char[name.length()];
		for ( int i=0; i<name.length(); i++ ) {
			reverse[i] = name.charAt(name.length()-i-1);
		}
		System.out.println(reverse);
	}
}
