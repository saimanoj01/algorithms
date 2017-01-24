package algorithms.dp;

/**
 * Created by saima_000 on 9/24/2016.
 */
public class MaxPalindromeSubsequence {
    private static int[][] dp;
    private static int subsequence(char[] data, int start, int end) {
        if(start == end)
            return 1;
        if(start > end) {
            return 0;
        }
        if(dp[start][end] != -1)
            return dp[start][end];
        int max = 0;
        if(data[start] == data[end]) {
            max = Math.max(max, subsequence(data, start+1, end-1) + 2);
        }
        else {
            max = Math.max(max, Math.max(subsequence(data, start+1, end), subsequence(data, start, end-1)));
        }
        dp[start][end] = max;
        return max;
    }

    public static void main(String[] args) {
        char[] data = "GEEKSFORGEEKS".toCharArray();
        dp = new int[data.length][];
        for(int i=0;i<data.length;i++) {
            dp[i] = new int[data.length];
        }
        for(int i=0;i<data.length;i++)
            for(int j=0;j<data.length;j++)
                dp[i][j] = -1;
        System.out.println(subsequence(data, 0, data.length-1));
    }
}
