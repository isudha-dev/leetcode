package leetcode;

public class LC1140 {
    static int iterations = 0;
    public static void main(String[] args) {
        stoneGameII(new int[]{1,2,3,4,5,100});
    }

    public static int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][][] dpArr = new int[2][n+1][n+1];
        int ans =  solveForAlice(true, 0, 1, piles, dpArr);
        System.out.println(iterations);
        return ans;
    }

    public static int solveForAlice(boolean isAlice, int i, int M, int[] piles, int[][][] dpArr){
        iterations++;
        int n = piles.length;
        if(i >= n){
            return 0;
        }

        if(dpArr[isAlice ? 0 : 1][i][M] != 0){
            return dpArr[isAlice ? 0 : 1][i][M];
        }

        int stones = 0;
        int result = isAlice ? -1 : Integer.MAX_VALUE;

        for (int x = 1; x <= Math.min(2*M, n-i); x++) {
            if(isAlice){
                stones += piles[i+x-1];
                result = Math.max(result, stones + solveForAlice(false, i+x, Math.max(M, x), piles, dpArr));
            } else {
                result = Math.min(result, solveForAlice(true, i+x, Math.max(M, x), piles, dpArr));
            }
        }
        dpArr[isAlice ? 0 : 1][i][M] = result;
        return result;
    }
}
