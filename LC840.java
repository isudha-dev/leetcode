package leetcode;

import java.util.HashSet;

public class LC840 {

    public static void main(String[] args) {
        int[][] grid = new int[5][5];
        grid[0] = new int[] {3,10,2,3,4};
        grid[1] = new int[] {4,5,6,8,1};
        grid[2] = new int[] {8,8,1,6,8};
        grid[3] = new int[] {1,3,5,7,1};
        grid[4] = new int[] {9,4,9,2,9};
        System.out.println(numMagicSquaresInside(grid));
    }
    public static int numMagicSquaresInside(int[][] grid) {
        // check from 1,1 to 1, c-2 (horizontally)
        // check from 1,1 to r-2, 1 (vertically)
        // if( any cell == 5)
        // make 4 checks from (lets say for i,j) ->
        // i-1, j-1     i+1, j+1
        // i-1, j       i+1, j
        // i-1, j+1     i+1, j-1
        // i, j+1       i, j-1
        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        if(rows <3 || cols <3)
            return 0;

        int r = 1;
        while(r <= rows-2){
            int c = 1;
            while(c <= cols-2){
                if(grid[r][c] == 5){
                    if(fourCheck(r, c, grid))
                        ans++;
                }
                c++;
            }
            r++;
        }

        return ans;
    }

    public static boolean fourCheck(int i, int j, int[][] grid){
        HashSet<Integer> set = new HashSet<>();
        if(grid[i-1][j-1] + grid[i+1][j+1] != 10)
            return false;
        set.add(grid[i-1][j-1]);
        set.add(grid[i+1][j+1]);

        if(grid[i-1][j] + grid[i+1][j] != 10)
            return false;
        set.add(grid[i-1][j]);
        set.add(grid[i+1][j]);

        if(grid[i-1][j+1] + grid[i+1][j-1] != 10)
            return false;
        set.add(grid[i-1][j+1]);
        set.add(grid[i+1][j-1]);

        if(grid[i][j+1] + grid[i][j-1] != 10)
            return false;
        set.add(grid[i][j+1]);
        set.add(grid[i][j-1]);

        if(grid[i-1][j-1] + grid[i-1][j] + grid[i-1][j+1] != 15)
            return false;

        if(grid[i-1][j-1] + grid[i][j-1] + grid[i+1][j-1] != 15)
            return false;

        if(set.size() != 8)
            return false;

        if(set.stream().filter(n -> n > 9 || n < 1).count() > 0)
            return false;

        return true;
    }
}
