package leetcode;

import java.util.Arrays;

public class LC1568 {
    public int minDays(int[][] grid) {
        int numOfIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == 1){
                    dfs(i, j, grid, visited);
                    numOfIslands++;
                }

            }
        }
        if(numOfIslands > 1)
            return 0;

        int count1s = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    count1s++;
            }
        }
        if(count1s <= 2)
            return count1s;

        int[] rowCount = new int[grid.length];
        int[] colCount = new int[grid[0].length];

        // todo :  find the total num of 1's in row which are not contiguous
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            if(rowCount[i] == 0)
                rowCount[i] = Integer.MAX_VALUE;
        }

        for (int j = 0; j < grid[0].length; j++) {
            if(colCount[j] == 0)
                colCount[j] = Integer.MAX_VALUE;
        }

        int minRow = Arrays.stream(rowCount).reduce(Math::min).getAsInt();
        int minCol = Arrays.stream(colCount).reduce(Math::min).getAsInt();

        return Math.min(minRow, minCol) == 1 ? 1 : 2;
    }

    private static void dfs(int i, int j, int[][] grid, boolean[][] visited){
        visited[i][j] = true;

        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int iN = rows[k]+i;
            int jN = cols[k]+j;

            if(iN >= 0 && iN < grid.length && jN >= 0 && jN < grid[0].length && !visited[iN][jN] && grid[iN][jN] == 1)
                dfs(iN, jN, grid, visited);
        }

    }
}
