package algorithms;

import java.util.Arrays;

/**
 * Created by saima_000 on 1/20/2017.
 */
public class Triangle {
    public void triangle(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char ch = chars[0];
        int fr = 0;
        for(int i=0;i<s.length();i++) {
            char temp = chars[i];
            char temp_count = 0;
            while(temp == chars[i++]) {
                temp_count++;
            }
            if(temp_count > fr || (temp_count == fr && s.charAt(temp) < s.charAt(ch))) {
                fr = temp_count;
                ch = temp;
            }
        }
        System.out.print(ch);
    }

    public static void main(String[] args) {
        Triangle t = new Triangle();
        t.triangle("sai");
    }
}
