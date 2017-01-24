package algorithms.dp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int[][] data;
    private static int[][] rows;
    private static int[][] cols;

    private static int nextTop(int row, int col1, int col2) {
        for(int i=row+1;i<data.length;i++) {
            if((rows[i][col2] - Math.abs(rows[i][col1])) == (col2 - col1)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        int no_of_rows = Math.max(m,n), no_of_cols = Math.min(m,n);
        data = new int[no_of_rows][];
        for(int i=0;i<no_of_rows;i++)
            data[i] = new int[no_of_cols];
        for(int i=0;i<m;i++) {
            String s = in.next();
            for(int j=0;j<n;j++) {
                if(m == no_of_rows)
                    data[i][j] = s.charAt(j);
                else
                    data[j][i] = s.charAt(j);

            }
        }
        // Preprocess input data
        int[][] rows = new int[no_of_rows][], cols = new int[no_of_rows][];
        for(int i=0;i<no_of_rows;i++) {
            rows[i] = new int[no_of_cols];
            cols[i] = new int[no_of_cols];
        }
        for(int i=0;i<no_of_rows;i++) {
            for(int j=0;j<no_of_cols;j++) {
                if(j-1 < 0) {
                    if(data[i][j] == '.')
                        rows[i][j] = 0;
                    else
                        rows[i][j] = -1;
                }
                else {
                    if(data[i][j] == '.')
                        rows[i][j] = rows[i-1][j] + 1;
                    else
                        rows[i][j] = -1;
                }

                if(i-1 < 0) {
                    if(data[i][j] == '.')
                        cols[i][j] = 0;
                    else
                        cols[i][j] = -1;
                }
                else {
                    if(data[i][j] == '.')
                        cols[i][j] = cols[i-1][j] + 1;
                    else
                        cols[i][j] = -1;
                }
            }
        }

        int max = 0;
        for(int i=0;i<no_of_cols;i++) {
            for(int j=i+1;j<no_of_cols;j++) {
                int top = -1;
                while(true) {
                    top = nextTop(top, i, j);
                    if(top == -1)
                        break;
                    int temp_top = top;
                    for(int k=top+1;k<no_of_rows;k++) {
                        if(data[k][i] != '.' || data[k][j] != '.') {
                            temp_top = k;
                            break;
                        }
                        if((rows[k][j] - Math.abs(rows[k][i])) == (j-i)) {
                            max = Math.max(max, 2*(k-top) + 2*(j-i));
                        }
                    }
                    if(top == temp_top)
                        break;
                    else
                        top = temp_top;
                }
            }
        }

        if(max == 0)
            System.out.println("impossible");
        else
            System.out.println(max);
    }
}