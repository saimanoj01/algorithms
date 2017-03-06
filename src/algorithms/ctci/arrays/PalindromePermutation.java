package algorithms.ctci.arrays;

/**
 * Created by saima_000 on 2/27/2017.
 */
/**
 1. Use an integer as a bitmap to save the number of occurences(odd/even) of each english alphabet.
 2. If there are more than one 1's in the bitmap then the string is not a palindrome.
 **/

public class PalindromePermutation {
    public static boolean isPalindromePermutation(String input) {
        int bitmap = 0;
        for(int i=0;i<input.length();i++) {
            int index = input.charAt(i) - 'a';
            if(index >= 0 && index <= 26) {
                int mask = 1 << index;
                bitmap = bitmap ^ mask;
            }
        }

        bitmap = bitmap & (bitmap - 1);
        return bitmap == 0;
    }

    public static void main(String[] args) {
        String input = "sai";
        System.out.println(isPalindromePermutation(input));
    }
}