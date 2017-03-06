package algorithms.ctci.arrays;

/**
 * Created by saima_000 on 2/27/2017.
 */
/**
 1. Count the number of spaces.
 2. Then count the total number of characters in the new string.
 3. Start filling the array from the end.
 **/

public class URLify {
    public static void replaceSpaces(char[] input, int length) {
        int index = length - 1, resultIndex = input.length - 1;
        while(index != 0) {
            if(input[index] == ' ') {
                input[resultIndex--] = '0';
                input[resultIndex--] = '2';
                input[resultIndex--] = '%';
            }
            else {
                input[resultIndex--] = input[index];
            }
            index--;
        }
    }
    public static void main(String[] args) {
        char[] input = "Sai Manoj Bandiiiii".toCharArray();
        replaceSpaces(input, 15);
        for(int i=0;i<input.length;i++)  {
            System.out.print(input[i] + " ");
        }
    }
}
