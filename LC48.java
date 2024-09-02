package leetcode;

public class LC48 {
    public static void main(String[] args) {
        int[][] matrix = new int[7][7];
        matrix[0] = new int[]{ 1, 2, 3, 4, 5, 6, 6};
        matrix[1] = new int[]{ 7, 8, 9,10,11,12,12};
        matrix[2] = new int[]{13,14,15,16,17,18,18};
        matrix[3] = new int[]{19,20,21,22,23,24,24};
        matrix[4] = new int[]{25,26,27,28,29,30,20};
        matrix[5] = new int[]{31,32,33,34,35,36,36};
        matrix[6] = new int[]{37,38,39,40,41,42,42};
        rotate2(matrix);
    }

    public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            int p1 = 0, p2 = n-1;
            while (p1<p2){
                int temp = matrix[i][p1];
                matrix[i][p1] = matrix[i][p2];
                matrix[i][p2] = temp;
                p1++;
                p2--;
            }
        }
    }

    public static void rotate1(int[][] matrix) {
        int n = matrix.length;

        int i = 0;
        int gK = n-1;
        int gN = n-1;
        while (n > 1){
            int swaps = n-1;
            int j = i, k = gK;
            while (swaps >= 1){
                int temp = matrix[k][i];
                matrix[k][i] = matrix[gN][k];
                matrix[gN][k] = matrix[j][gN];
                matrix[j][gN] = matrix[i][j];
                matrix[i][j] = temp;
                j++;
                k--;
                swaps--;
            }
            n = n-2;
            i++;
            gK--;
            gN--;
        }

    }
}
