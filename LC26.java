package leetcode;

public class LC26 {
    public static void main(String[] args) {
        removeDuplicates(new int[] {-1, -1, 0, 0,1,1,1});
    }
    public static int removeDuplicates(int[] nums) {
        int idx = 1;
        int p1 = 1;
        while(idx < nums.length) {
            while(idx < nums.length && nums[idx] == nums[idx-1]) {
                idx++;
            }
            if(idx == nums.length)
                break;

            nums[p1] = nums[idx];
            p1++;
            idx++;
        }
        return p1;
    }
}
