package algorithms.dp;

/**
 * Created by saima_000 on 9/24/2016.
 */
public class MinCostPath {
    private static int[][] dp;
    private static int minCostTopDown(int[][] data, int x, int y) {
        if(x < 0 || y < 0)
            return Integer.MAX_VALUE;
        if(x==0 && y==0)
            return data[x][y];
        if(dp[x][y] != -1)
            return dp[x][y];
        dp[x][y] = data[x][y] + Math.min(minCostTopDown(data, x-1, y-1),Math.min(minCostTopDown(data, x-1, y), minCostTopDown(data, x, y-1)));
        return dp[x][y];
    }

    public static void main(String[] args) {
        int[][] input = {{1,2,3},{4,8,2},{1,5,3}};
        dp = new int[input.length][];
        for(int i=0;i<input.length;i++) {
            dp[i] = new int[input.length];
        }
        for(int i=0;i<input.length;i++)
            for(int j=0;j<input.length;j++)
                dp[i][j] = -1;
        System.out.println(minCostTopDown(input, 2, 2));
    }
}
