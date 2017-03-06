package algorithms.ctci.arrays;

/**
 * Created by saima_000 on 2/27/2017.
 */
/**
 1. Take input
 2. Set a int variable to 0 which can be used as bit mask.
 3. Iterate over all the characters and set the corresponding bit of the bit map to 1.
 4. If 1 is already seen, print false.
 **/
public class UniqueChars {
    public static boolean isUnique(String input) {
        int bitmask = 0;
        for(int i=0;i<input.length();i++) {
            int index = input.charAt(i) - 'a';
            if((bitmask & (1 << index)) > 0) {
                return false;
            }
            bitmask |= (1 << index);
        }
        return true;
    }
    public static void main(String[] args) {
        String input = "sai";
        System.out.println(isUnique(input));
    }
}
