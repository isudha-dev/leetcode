package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LC2134 {
    public static void main(String[] args) {
        System.out.println(minSwaps(new int[] {1,1,0,0}));
    }

    public static int minSwaps(int[] nums) {
        int n = nums.length;
        // for each subarray of size 1, see how many 0s it contains
        int count1 = (int) Arrays.stream(nums).filter(i -> i == 1).count();

        if(count1 == n || count1 == 0)
            return 0;

        int count0 = 0;
        int ans = Integer.MAX_VALUE;
        int p1 = 0;
        int p2 = count1-1;
        for (int i = p1; i <= p2; i++) {
            if(nums[i] == 0)
                count0++;
        }
        ans = Math.min(count0, ans);

        while (p1 < n-count1){
            if(nums[p1] == 0){
                count0--;
            }
            p1++;
            p2++;
            if(nums[p2] == 0){
                count0++;
            }
            ans = Math.min(count0, ans);
        }
        p2 = -1;
        while (p1 < n-1){
            if(nums[p1] == 0){
                count0--;
            }
            p1++;
            p2++;
            if(nums[p2] == 0){
                count0++;
            }
            ans = Math.min(count0, ans);
        }

        return ans;
    }
}
