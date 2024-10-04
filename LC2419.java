package leetcode;

public class LC2419 {

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[] {1,2,3,3,2,2}));
    }

    public static int longestSubarray(int[] nums) {

        int maxNum = Integer.MIN_VALUE;
        int startIdx = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > maxNum) {
                startIdx = i;
                maxNum = nums[i];
            }
        }

        int maxLen = 1;
        int endIdx = startIdx;
        for(int i = startIdx+1; i < nums.length; i++) {
            if(nums[i] == maxNum) {
                if(startIdx == -1) {
                    startIdx = i;
                    endIdx = startIdx;
                } else {
                    endIdx = i;
                }
                maxLen = Math.max(maxLen, endIdx-startIdx+1);
            } else {
                startIdx = -1;
            }
        }

        return maxLen;

    }
}
