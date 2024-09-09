package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC7 {

    public static void main(String[] args) {
        System.out.println(reverse(-1234567892));
    }
    public static int reverse(int x) {
        int ans = 0;
        boolean isNegative = x < 0 ? true : false;

        if(isNegative)
            x *= -1;

        while(x > 0) {
            if(Integer.MAX_VALUE/10 < ans) {
                return 0;
            }
            int pop = x%10;
            ans = ans * 10 + pop;
            x /= 10;

        }

        if (isNegative)
            return ans *= -1;

        return ans;
    }
}
