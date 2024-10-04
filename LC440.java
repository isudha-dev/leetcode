package leetcode;

import java.util.Arrays;

public class LC440 {

    public static void main(String[] args) {
        findKthNumber(10, 0);
    }

    public static int findKthNumber(int n, int k) {
        int[] ans = new int[100000];
        ans[0] = 1;
        ans[1] = 10;
        ans[2] = 100;
        ans[3] = 1000;
        ans[4] = 10000;
        ans[5] = 100000;

        int idx = 5;
        while (idx < ans.length) {
            if(idx == ans.length-4) {
                System.out.println("Pause");
            }
            int num = ans[idx] + 1;
            idx++;
            if(num % 10 == 0) {
                int temp = num;
                while (idx < ans.length && temp % 10 == 0) {
                    temp = temp/10;
                    ans[idx] = temp;
                    idx++;
                }
            }
            if(idx < ans.length)
                ans[idx] = num;
        }

        Arrays.stream(ans).forEach(System.out::println);
        return ans[k+1];

    }
}
