package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC54 {

    public static void main(String[] args) {
        int[][] matrix ={{3}, {2}};
        spiralOrder(matrix);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();

        int r = 0, c = 0;
        while(n > 1 && m > 1) {

            for(int l = 1; l < n; l++) {
                ans.add(matrix[r][c]);
                c++;
            }

            for(int l = 1; l < m; l++) {
                ans.add(matrix[r][c]);
                r++;
            }

            for(int l = 1; l < n; l++) {
                ans.add(matrix[r][c]);
                c--;
            }

            for(int l = 1; l < m; l++) {
                ans.add(matrix[r][c]);
                r--;
            }
            m -= 2;
            n -= 2;
            r++;
            c++;
        }

        if(n > 1 && m == 1) {
            // 1 row
            for(int l = 1; l<=n; l++) {
                ans.add(matrix[r][c]);
                c++;
            }
        }

        if(m > 1 && n == 1) {
            // 1 col
            for(int l = 1; l<=m; l++) {
                ans.add(matrix[r][c]);
                r++;
            }
        }

        if(m == 1 && n == 1) {
            // 1 cell
            ans.add(matrix[r][c]);
        }

        return ans;

    }
}
