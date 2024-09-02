package leetcode;

public class LC959 {
    public static void main(String[] args) {
        String[] grid = new String[2];
        grid[0] = " /";
        grid[1] = "/ ";
        regionsBySlashes(grid);
    }
    public static int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] arr = new int[n*3][n*3];

        for(int i = 0; i< grid.length; i++){
            String s = grid[i];
            int l = 0;
            for(int j = 0; j<s.length(); j++){
                char c = s.charAt(j);
                int baseRow = i * 3;
                int baseCol = j * 3;
                if (c == '\\') {
                    // Mark diagonal for backslash
                    arr[baseRow][baseCol] = 1;
                    arr[baseRow + 1][baseCol + 1] = 1;
                    arr[baseRow + 2][baseCol + 2] = 1;
                } else if (c == '/') {
                    // Mark diagonal for forward slash
                    arr[baseRow][baseCol + 2] = 1;
                    arr[baseRow + 1][baseCol + 1] = 1;
                    arr[baseRow + 2][baseCol] = 1;
                }
            }
        }

        boolean[][] visited = new boolean[n*3][n*3];
        int count = 0;
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                if(!visited[i][j] && arr[i][j] == 0){
                    dfs(i, j, arr, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int i, int j, int[][] arr, boolean[][] visited) {
        visited[i][j] = true;

        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, 1, 0, -1};

        for(int k = 0; k<4; k++){
            int iN = rows[k]+i;
            int jN = cols[k]+j;

            if(iN >=0 && iN < arr.length && jN >= 0 && jN < arr[0].length && !visited[iN][jN] && arr[iN][jN] == 0){
                dfs(iN, jN, arr, visited);
            }
        }
    }
}
