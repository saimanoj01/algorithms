package algorithms.epi.strings;

/**
 * Created by saima_000 on 1/31/2017.
 */
public class IntToString {
    public static void main(String[] args) {
        String input = "12345";
        int integer = 0, i = input.length()-1;
        while(i >= 0 && !(input.charAt(i) == '-' || input.charAt(i) == '+')) {
            integer = (int)(integer + ((int)input.charAt(i) - (int)'0') * Math.pow(10, input.length() - (i + 1)));
            i--;
        }
        if(input.charAt(0) == '-')
            integer = -1 * integer;
        System.out.println(integer);
    }
}
