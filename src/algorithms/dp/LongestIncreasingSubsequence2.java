package algorithms.dp;

/**
 * Created by saima_000 on 9/27/2016.
 */
public class LongestIncreasingSubsequence2 {
    private static int[] dpTable(int[] data) {
        int[] dp = new int[data.length];
        for(int i=0;i<dp.length;i++) {
            dp[i] = -1;
        }
        for(int i=dp.length-1;i>=0;i--) {
            for(int j=i+1;j<dp.length;j++) {
                if(data[j] > data[i]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            dp[i] = Math.max(dp[i], 1);
        }
        return dp;
    }

    private static void lisLength(int[] data) {
        int[] dp = dpTable(data);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    private static void printLis(int[] data) {
        int[] dp = dpTable(data);
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i=0;i<dp.length;i++) {
            if(dp[i] >= max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        printLisRecursive(data, dp, maxIndex);
    }

    private static void printLisRecursive(int[] data, int[] dp, int index) {
        System.out.print(data[index] + "    ");
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i=index+1;i<data.length;i++) {
            if(data[i] > data[index]) {
                if(dp[i] > max) {
                    max = dp[i];
                    maxIndex = i;
                }
            }
        }
        if(maxIndex != -1)
            printLisRecursive(data, dp, maxIndex);
    }

    public static void main(String[] args) {
        int[] input = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        lisLength(input);
        printLis(input);
    }
}
