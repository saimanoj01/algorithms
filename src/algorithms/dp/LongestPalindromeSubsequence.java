package algorithms.dp;

/**
 * Created by saima_000 on 9/27/2016.
 */
public class LongestPalindromeSubsequence {
    private static int lps(char[] data, int start, int end, int[][] dp) {
        if(start > end)
            return 0;
        if(start == end) {
            dp[start][end] = 1;
            return 1;
        }
        if(dp[start][end] != -1)
            return dp[start][end];
        int result;
        if(data[start] == data[end]) {
            result = 2+lps(data, start+1, end-1, dp);
        }
        else {
            result = Math.max(lps(data, start+1, end, dp), lps(data, start, end-1, dp));
        }
        dp[start][end] = result;
        return result;
    }

    private static void printLps(char[] data, int[][] dp, int start, int end) {
        if(start > end)
            return;
        if(dp[start][end] == 1) {
            System.out.print(data[start] + "    ");
            return;
        }
        if(data[start] == data[end]) {
            System.out.print(data[start] + "    ");
            printLps(data, dp, start+1, end-1);
            System.out.print(data[start] + "    ");
        }
        else {
            if(dp[start+1][end] > dp[start][end-1])
                printLps(data, dp, start+1, end);
            else
                printLps(data, dp, start, end-1);
        }
    }

    public static void main(String[] args) {
        char[] input = "character".toCharArray();
        int[][] dp = new int[input.length][];
        for(int i=0;i<input.length;i++)
            dp[i] = new int[input.length];
        for(int i=0;i<input.length;i++)
            for(int j=0;j<input.length;j++)
                dp[i][j] = -1;
        System.out.println(lps(input, 0, input.length-1, dp));
        printLps(input, dp, 0, input.length-1);
    }
}
