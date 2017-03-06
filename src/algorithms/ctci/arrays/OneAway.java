package algorithms.ctci.arrays;

/**
 * Created by saima_000 on 2/27/2017.
 */
/**
 1. Take the shorter string and start comparing it with other letter by letter.
 2. If comparision fails, mark a flag and go forward depending on the below conditions.
 3. if the lengths of both the strings are equal. Increment the pointer of both the strings.
 4. If the lengths are unequal, increment the pointer of the longer string.
 5. If the comparision fails again (more than 1), then return false.
 **/

public class OneAway {
    public static boolean oneEditAway(String first, String second) {
        String input1 = first.length() < second.length() ? first : second;
        String input2 = first.length() < second.length() ? second : first;
        int index1 = 0, index2 = 0;
        boolean flag = false;
        while(index1 < input1.length() && index2 < input2.length()) {
            if(input1.charAt(index1) != input2.charAt(index2)) {
                if(!flag) {
                    flag = true;
                } else {
                    return false;
                }
                if(input1.length() == input2.length()) {
                    index1++;
                }
            }
            else {
                index1++;
            }
            index2++;
        }
        return true;
    }

    public static void main(String[] args) {
        String input1 = "pale", input2 = "bae";
        System.out.println(oneEditAway(input1, input2));
    }
}