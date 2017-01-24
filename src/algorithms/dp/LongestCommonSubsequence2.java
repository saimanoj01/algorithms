package algorithms.dp;

/**
 * Created by saima_000 on 9/27/2016.
 */
public class LongestCommonSubsequence2 {
    private static int lcsTopDown(char[] input1, char[] input2, int index1, int index2, int[][] dp) {
        int result;
        if(index1<0 || index2<0) {
            return 0;
        }
        if(dp[index1][index2] != -1)
            return dp[index1][index2];
        if(input1[index1] == input2[index2]) {
            result = 1+lcsTopDown(input1, input2, index1-1, index2-1, dp);
        }
        else {
            result = Math.max(lcsTopDown(input1, input2, index1-1, index2, dp), lcsTopDown(input1, input2, index1, index2-1, dp));
        }
        dp[index1][index2] = result;
        return result;
    }
    private static int[][] lcsBottomUp(char[] input1, char[] input2) {
        int[][] dp = new int[input1.length][];
        for(int i=0;i<input1.length;i++)
            dp[i] = new int[input2.length];
        for(int i=0;i<input1.length;i++) {
            for(int j=0;j<input2.length;j++) {
                if(input1[i] == input2[j]) {
                    dp[i][j] = (i-1 >= 0 && j-1 >= 0)?(1+dp[i-1][j-1]):(1);
                }
                else {
                    if(i-1 < 0 && j-1 < 0) {
                        dp[i][j] = 0;
                    }
                    else if(i-1 < 0) {
                        dp[i][j] = dp[i][j-1];
                    }
                    else if(j-1 < 0) {
                        dp[i][j] = dp[i-1][j];
                    }
                    else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp;
    }

    private static void lcsBottomUpLength(char[] input1, char[] input2) {
        int[][] dp = lcsBottomUp(input1, input2);
        System.out.println(dp[input1.length-1][input2.length-1]);
    }

    private static void lcsBottomUpSequence(char[] input1, char[] input2) {
        int[][] dp = lcsBottomUp(input1, input2);
        int i = input1.length-1, j = input2.length-1;
        while(i >= 0 && j >= 0) {
            if(input1[i] == input2[j]) {
                System.out.print(input1[i] + "  ");
                i--;
                j--;
            }
            else {
                if(i-1 >=0 && j-1 >= 0) {
                    if(dp[i-1][j] > dp[i][j-1])
                        i--;
                    else
                        j--;
                }
                else if(i-1 >= 0)
                    i--;
                else
                    j--;
            }
        }
    }

    private static void lcsBottomUpSequenceRecursive(char[] input1, char[] input2, int[][] dp, int index1, int index2) {
        if(index1 < 0 || index2 < 0)
            return;
        if(input1[index1] == input2[index2]) {
            lcsBottomUpSequenceRecursive(input1, input2, dp, index1-1, index2-1);
            System.out.print(input1[index1] + "  ");
        }
        else {
            if(index1-1 >= 0 && index2-1 >= 0) {
                if(dp[index1-1][index2] > dp[index1][index2-1])
                    lcsBottomUpSequenceRecursive(input1, input2, dp, index1-1, index2);
                else
                    lcsBottomUpSequenceRecursive(input1, input2, dp, index1, index2-1);
            }
            else if(index1-1 >= 0)
                lcsBottomUpSequenceRecursive(input1, input2, dp, index1-1, index2);
            else if(index2-1 >= 0)
                lcsBottomUpSequenceRecursive(input1, input2, dp, index1, index2-1);
            else
                return;
        }
    }

    private static void lcsBottomUpSavedSpace(char[] input1, char[] input2) {
        if(input2.length > input1.length) {
            char[] temp = input1;
            input1 = input2;
            input2 = temp;
        }
        int[][] dp = new int[2][];
        for(int i=0;i<2;i++) {
            dp[i] = new int[input2.length];
        }
        for(int i=0;i<input1.length;i++) {
            for(int j=0;j<input2.length;j++) {
                if(input1[i] == input2[j]) {
                    dp[i%2][j] = (i-1 >= 0 && j-1 >= 0)?(1+dp[(i-1)%2][j-1]):(1);
                }
                else {
                    if(i-1 >= 0 && j-1 >= 0) {
                        dp[i%2][j] = Math.max(dp[(i-1)%2][j],dp[i%2][j-1]);
                    }
                    else if(i-1 >= 0) {
                        dp[i%2][j] = dp[(i-1)%2][j];
                    }
                    else if(j-1 >= 0) {
                        dp[i%2][j] = dp[i%2][j-1];
                    }
                    else {
                        dp[i%2][j] = 0;
                    }
                }
            }
        }
        System.out.println(dp[(input1.length-1) % 2][input2.length-1]);
    }

    private static void lcsBottomUpSaveSpaceV2(char[] input1, char[] input2) {
        if(input2.length > input1.length) {
            char[] temp = input1;
            input1 = input2;
            input2 = temp;
        }
        int[] dp = new int[input2.length];
        for(int i=0;i<input1.length;i++) {
            int temp=100;  // dummy initialization.
            for(int j=0;j<input2.length;j++) {
                int temp1;
                if(input1[i] == input2[j])
                    temp1 = (i-1 >= 0 && j-1 >= 0)?(1+dp[j-1]):(1);
                else {
                    if(i-1 >=0 && j-1 >= 0)
                        temp1 = Math.max(temp, dp[j]);
                    else if(i-1 >= 0)
                        temp1 = dp[j];
                    else if(j-1 >= 0)
                        temp1 = temp;
                    else
                        temp1 = 0;
                }
                if(j-1 >= 0)
                    dp[j-1] = temp;
                if(j == input2.length-1)
                    dp[j] = temp1;
                temp = temp1;
            }
        }
        System.out.println(dp[input2.length-1]);
    }

    public static void main(String[] args) {
        char[] input1 = "ABCBDAAB".toCharArray(), input2 = "BDCAABA".toCharArray();
        int[][] dp = new int[input1.length][];
        for(int i=0;i<input1.length;i++)
            dp[i] = new int[input2.length];
        for(int i=0;i<input1.length;i++)
            for(int j=0;j<input2.length;j++)
                dp[i][j] = -1;
        System.out.println(lcsTopDown(input1, input2, input1.length-1, input2.length-1, dp));
        lcsBottomUpLength(input1, input2);
        lcsBottomUpSequence(input1, input2);
        System.out.println();
        lcsBottomUpSequenceRecursive(input1, input2, lcsBottomUp(input1, input2),input1.length-1, input2.length-1);
        System.out.println();
        lcsBottomUpSavedSpace(input1, input2);
        lcsBottomUpSaveSpaceV2(input1, input2);
    }
}
