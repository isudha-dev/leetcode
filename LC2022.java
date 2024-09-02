package leetcode;

public class LC2022 {

    public static void main(String[] args) {
        construct2DArray(new int[] {3}, 1, 2);
    }
    public static int[][] construct2DArray(int[] original, int m, int n) {

        int[][] ans = new int[m][n];

        if(original.length != m*n) {
            return new int[0][0];
        }

        int idx = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++) {
                ans[i][j] = original[idx];
                idx++;
            }
        }

        return ans;

    }
}
