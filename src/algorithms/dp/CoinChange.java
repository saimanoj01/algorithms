package algorithms.dp;

import java.util.HashMap;

/**
 * Created by saima_000 on 9/24/2016.
 */
public class CoinChange {
    private static int coinChange(int value, int[] denomination, int[] dp) {
        if(value == 0)
            return 0;
        if(dp[value-1] != -1)
            return dp[value-1];
        int temp = Integer.MAX_VALUE;
        for(int i=0;i<denomination.length;i++) {
            if(value >= denomination[i]) {
                temp = Math.min(temp, coinChange(value-denomination[i], denomination, dp));
            }
        }
        if(temp == Integer.MAX_VALUE) {
            dp[value - 1] = Integer.MAX_VALUE;
            return dp[value-1];
        }
        dp[value-1] = temp + 1;
        return dp[value-1];
    }

    private static void printCoinChange(int value, int[] denomination, int[] dp) {
        if(value == 0)
            return;
        for(int i=0;i<denomination.length;i++) {
            if(value == denomination[i])
                System.out.println(denomination[i] + "  ");
            if(value > denomination[i]) {
                if(dp[value-1] == dp[value-denomination[i]-1] + 1) {
                    System.out.print(denomination[i] + "    ");
                    printCoinChange(value-denomination[i], denomination, dp);
                }
            }
        }
    }
    public static void main(String[] args) {
        int value = 10;
        int[] denomination = {2, 5, 3, 6};
        int[] dp = new int[value];
        for(int i=0;i<dp.length;i++)
            dp[i] = -1;
        System.out.println(coinChange(value, denomination, dp));
        printCoinChange(value, denomination, dp);
    }
}
