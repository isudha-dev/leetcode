package leetcode;

import java.util.HashMap;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
            } else if (!map.containsKey(nums[i]))
                map.put(nums[i], i);
        }

        return ans;

    }
}
// @lc code=end
