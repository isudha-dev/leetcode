package leetcode;

public class LC1310 {

    public static void main(String[] args) {
        xorQueries(new int[] {1,3,4,8} , new int[][] {{0,1}, {1,2}, {0,3}, {3,3}});
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] preXor = new int[n];

        preXor[0] = arr[0];
        for(int i = 1; i<n; i++) {
            preXor[i] = preXor[i-1] ^ arr[i];
        }

        int[] ans = new int[queries.length];
        int idx = 0;
        for(int[] query: queries) {
            if(query[0] == 0) {
                ans[idx++] = preXor[query[1]];
            } else {
                ans[idx++] = preXor[query[0]-1] ^ preXor[query[1]];
            }
        }

        return ans;
        /*
         1 2 6 14

         6^1 = 7
         110
         001
         ---
         111

         0110
         1110
         ----
         1000

         010
         100
         ---
        0110
        1000
        ----
        1110


        */
    }
}
