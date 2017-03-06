package algorithms.ctci.arrays;

/**
 * Created by saima_000 on 2/27/2017.
 */
/*
    1. Create an array of integers of size 256(ascii) to check for the frequency of the letters.
    2. Iterate over the first string and increment the count of the respective characters in the integer array.
    3. Now iterate over the second array and start decrementing the count for each character.
    4. If the count turns negative, stop then and there.
    5. Else at the end iterate over all the entries in the array and make sure each value is 0.
*/

public class CheckPermutation {
    public static boolean isPermutation(String input1, String input2) {
        int[] map = new int[256];
        for(int i=0;i<input1.length();i++) {
            map[input1.charAt(i) - 'a'] = map[input1.charAt(i) - 'a'] + 1;
        }

        for(int i=0;i<input2.length();i++) {
            map[input2.charAt(i) - 'a'] = map[input2.charAt(i) - 'a'] - 1;
            if(map[input2.charAt(i) - 'a'] < 0)
                return false;
        }

        for(int i=0;i<map.length;i++) {
            if(map[i] != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String input1 = "manoj", input2 = "joanam";
        System.out.println(isPermutation(input1, input2));
    }
}
