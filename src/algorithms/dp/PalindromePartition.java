package algorithms.dp;

/**
 * Created by saima_000 on 9/24/2016.
 * http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 */

public class PalindromePartition {
    private static int palindromePartition(char[] data, boolean[][] pal, int index) {
        if(index >= data.length-1 || pal[index][data.length-1])
            return 0;
        int min = Integer.MAX_VALUE;
        for(int i=index;i<data.length;i++) {
            if(pal[index][i]) {
                min = Math.min(min, palindromePartition(data, pal, i + 1));
            }
        }
        return min+1;
    }

    private static boolean[][] getAllPalindromesArray(char[] data) {
        boolean[][] palindrome = new boolean[data.length][];
        for(int i=0;i<data.length;i++)
            palindrome[i] = new boolean[data.length];
        for(int i=0;i<data.length;i++)
            for(int j=0;j<data.length;j++) {
                int x = j;
                int y = j + i;
                if(y < data.length) {
                    if (x == y) {
                        palindrome[x][y] = true;
                    }
                    else if ((y - x) == 1) {
                        if (data[x] == data[y])
                            palindrome[x][y] = true;
                        else
                            palindrome[x][y] = false;
                    }
                    else
                        palindrome[x][y] = (palindrome[x + 1][y - 1] && (data[x] == data[y]));
                }
            }
        return palindrome;
    }

    public static void main(String[] args) {
        char[] input = "abb".toCharArray();
        boolean[][] pal = getAllPalindromesArray(input);
        System.out.println(palindromePartition(input, pal, 0));
    }
}
