package leetcode;/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class MaxArea {
    public static void main(String[] args) {
        maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
    }

    public static int maxArea(int[] height) {
        int ans = Integer.MIN_VALUE;

        int p1 = 0, p2 = height.length - 1;
        while (p1 < p2) {
            int len = Math.min(height[p1], height[p2]);
            int wid = p2 - p1;
            int area = len * wid;
            ans = Math.max(ans, area);
            if (height[p1] <= height[p2])
                p1++;
            else
                p2--;
        }

        return ans;
    }
}
// @lc code=end
