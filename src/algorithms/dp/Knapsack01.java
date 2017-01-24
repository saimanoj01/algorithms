package algorithms.dp;

import java.util.HashMap;
import java.util.Timer;

/**
 * Created by saima_000 on 9/24/2016.
 */
public class Knapsack01 {
    private static int knapsack(int[] weights, int[] benefit, int maxWeight, int index, int[][] dp) {
        if(maxWeight == 0 || index == weights.length)
            return 0;
        if(dp[index][maxWeight-1] != -1)
            return dp[index][maxWeight];
        int result;
        if(weights[index] > maxWeight)
            result = knapsack(weights, benefit, maxWeight, index+1, dp);
        else {
            result = Math.max(benefit[index] + knapsack(weights, benefit, maxWeight-weights[index], index+1, dp), knapsack(weights, benefit, maxWeight, index+1, dp));
        }
        dp[index][maxWeight-1] = result;
        return result;
    }

    private static void generateKnapsack(int[] weights, int[] benefit, int maxWeight, int index, int[][] dp) {
        if(maxWeight == 0 || index == weights.length)
            return;
        if(weights[index] > maxWeight)
            generateKnapsack(weights, benefit, maxWeight, index+1, dp);
        else {
            if(index == weights.length-1 || weights[index] == maxWeight) {
                System.out.print(index + "  ");
                return;
            }
            if((benefit[index] + dp[index+1][maxWeight - weights[index] -1] > dp[index+1][maxWeight-1])) {
                System.out.print(index + "  ");
                generateKnapsack(weights, benefit, maxWeight - weights[index], index + 1, dp);
            } else
                generateKnapsack(weights, benefit, maxWeight, index + 1, dp);
        }
    }

    public static void main(String[] args) {
        int[] benefit = {92, 57, 49, 68, 60, 43, 67, 84, 87, 72}, weights = {23, 31, 29, 44, 53, 38, 63, 85, 89, 82};
        int maxWeight = 192;
        int[][] dp = new int[weights.length][];
        for(int i=0;i<weights.length;i++)
            dp[i] = new int[maxWeight];
        for(int i=0;i<weights.length;i++)
            for(int j=0;j<maxWeight;j++)
                dp[i][j] = -1;
        System.out.println("Max Benefit : " + knapsack(weights, benefit, maxWeight, 0, dp));
        generateKnapsack(weights, benefit, maxWeight, 0, dp);
    }
}
