package leetcode;

import java.util.Arrays;

public class LC1937 {
    public static void main(String[] args) {
        int[][] points = new int[3][3];
        points[0] = new int[] {1,5};
        points[1] = new int[] {2,3};
        points[2] = new int[] {4,2};
        maxPoints2(points);
    }

    public static long maxPoints(int[][] points) {
        // this solution gives TLE for large input because TC is O(n*m*m)
        int rows = points.length;
        int cols = points[0].length;

        long[][] dpArr = new long[rows][cols];
        for(int c = 0; c<cols; c++){
            dpArr[0][c] = points[0][c];
        }

        for (int r = 1; r < rows; r++) {
            for (int c1 = 0; c1 < cols; c1++) {
                long max = Long.MIN_VALUE;
                for (int c2 = 0; c2 < cols; c2++) {
                    long colDiff = Math.abs(c1-c2);
                    long colSum = dpArr[r-1][c2]+ (long) points[r][c1];
                    max = Math.max(max, colSum-colDiff);
                }
                dpArr[r][c1] = max;
            }
        }

        long ans = Integer.MIN_VALUE;
        for(int c = 0; c<cols; c++){
            ans = Math.max(ans, dpArr[rows-1][c]) ;
        }

        return ans;
    }

    public static long maxPoints2(int[][] points) {
        int rows = points.length;
        int cols = points[0].length;

        long[] previousRow = new long[cols];
        for (int c = 0; c < cols; c++) {
            previousRow[c] = (long) points[0][c];
        }

        for (int r = 1; r < rows; r++) {
            long[] leftMax = new long[cols];
            long[] rightMax = new long[cols];

            leftMax[0] = previousRow[0];
            for (int i = 1; i < cols; i++) {
                leftMax[i] = Math.max(previousRow[i], leftMax[i-1]-1);
            }

            rightMax[cols-1] = previousRow[cols-1];
            for (int i = cols-2; i >= 0 ; i--) {
                rightMax[i] = Math.max(previousRow[i], rightMax[i+1]-1);
            }

            long[] currentRow = new long[cols];

            for (int c = 0; c < cols; c++) {
                currentRow[c] = Math.max(leftMax[c], rightMax[c]) + points[r][c];
            }

            previousRow = currentRow;
        }

        long ans = Integer.MIN_VALUE;
        for(int c = 0; c<cols; c++){
            ans = Math.max(ans, previousRow[c]) ;
        }

        return ans;
    }
}
