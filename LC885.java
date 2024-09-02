package leetcode;

import java.util.Arrays;

public class LC885 {

    public static void main(String[] args) {
        int[][] ans = spiralMatrixIII(1,4,0,0);
        Arrays.stream(ans).forEach(a -> System.out.println(a[0]+", "+a[1]));
    }
    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int mv = 1;
        int ansFound = 0;
        int totValues = rows*cols;
        int[][] ans = new int[rows*cols][2];
        ans[ansFound][0] = rStart;
        ans[ansFound][1] = cStart;

        // move right and down by mv
        // move to next in left dir
        // increment mv by 1
        // move left and up by mv
        // move to next in right dir
        // increment mv by 1

        while (ansFound < totValues-1){
            for (int i = 0; i < mv; i++) {
                cStart++;
                if (rStart >= 0 && rStart < rows && cStart >=0 && cStart < cols) {
                    ansFound++;
                    if(ansFound >= totValues)
                        break;
                    ans[ansFound][0] = rStart;
                    ans[ansFound][1] = cStart;
                }
            }
            for (int i = 0; i < mv; i++) {
                rStart++;
                if (rStart >= 0 && rStart < rows && cStart >=0 && cStart < cols) {
                    ansFound++;
                    if(ansFound >= totValues)
                        break;
                    ans[ansFound][0] = rStart;
                    ans[ansFound][1] = cStart;
                }
            }
            mv++;
            for (int i = 0; i < mv; i++) {
                cStart--;
                if (rStart >= 0 && rStart < rows && cStart >=0 && cStart < cols) {
                    ansFound++;
                    if(ansFound >= totValues)
                        break;
                    ans[ansFound][0] = rStart;
                    ans[ansFound][1] = cStart;
                }
            }
            for (int i = 0; i < mv; i++) {
                rStart--;
                if (rStart >= 0 && rStart < rows && cStart >=0 && cStart < cols) {
                    ansFound++;
                    if(ansFound >= totValues)
                        break;
                    ans[ansFound][0] = rStart;
                    ans[ansFound][1] = cStart;
                }
            }
            mv++;

        }

        return ans;

    }
}
