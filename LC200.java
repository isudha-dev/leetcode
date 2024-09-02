package leetcode;

public class LC200 {
    public static void main(String[] args) {
        char[][] grid = new char[1][1];
        grid[0] = new char[] {'1'};
//        grid[1] = new char[] {'1','1','0','0','0'};
//        grid[2] = new char[] {'0','0','1','0','0'};
//        grid[3] = new char[] {'0','0','0','1','1'};
        System.out.println(numIslands(grid));

    }
    public static int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(i, j, visited, grid, rows, cols);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, boolean[][] visited, char[][] grid, int rows, int cols) {
        visited[i][j] = true;

        int[] rs = {-1, 0, 1, 0};
        int[] cs = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int iN = rs[k]+i;
            int jN = cs[k]+j;
            if(iN >= 0 && iN < rows && jN >= 0 && jN < cols && grid[iN][jN] == '1' && !visited[iN][jN]){
                dfs(iN, jN, visited, grid, rows, cols);
                visited[iN][jN] = true;
            }
        }
    }
}
