import java.util.regex.*;

public class Regex {
	public static void main(String[] args) {
		String pwd = "12344&t";
		 String pattern = "((?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@$%&*]).{8,})";
			System.out.println(pwd.matches(pattern)?"VALID":"INVALID");
		
	}
}
