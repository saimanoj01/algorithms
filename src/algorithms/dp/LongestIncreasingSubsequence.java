package algorithms.dp;

/**
 * Created by saima_000 on 9/24/2016.
 */
public class LongestIncreasingSubsequence {

    private static int[] dp;

    // Top-down approach - Memoization.
    private static int subsequenceMemoization(int[] data, int index) {
        if (dp[index] != -1) {
            return dp[index];
        }
        if (index == data.length) {
            return 0;
        }
        int max = 0;
        for (int i = index + 1; i < data.length; i++) {
            if (data[i] > data[index]) {
                int temp = subsequenceMemoization(data, i);
                max = (temp > max ? temp : max);
            }
        }
        dp[index] = max + 1;
        return max + 1;
    }

    // Bottom up approach - no recursion.
    private static int subsequenceBottomUp(int[] data) {
        int[] aux = new int[data.length];
        aux[aux.length - 1] = 1;
        for (int i = aux.length - 2; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < aux.length; j++) {
                if (data[j] > data[i]) {
                    int temp = aux[j];
                    max = (temp > max ? temp : max);
                }
            }
            aux[i] = max + 1;
        }

        int max = 0;
        for (int element : aux) {
            max = (element > max ? element : max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        // Create and initialize an array for memoization.
        dp = new int[input.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        subsequenceMemoization(input, 0);
        // Find maximum from the memoization array.
        int max = 0;
        for (int element : dp) {
            max = (element > max ? element : max);
        }
        System.out.println(subsequenceBottomUp(input));
    }
}
