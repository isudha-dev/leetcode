package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LC31 {
    public static void main(String[] args) {
        nextPermutation(new int[] {3,2,1});
        //
    }

    // 1,1,5
    /*
    1 5 1

    8 9 1
    9 8 1
    1 3 4 8 6
    1 3 6 4 8
    // find first decreasing number - at index i
    // find smallest bigger num from i+1 - at index j
    // update n[j] at i and n[i]
    // sort numbers from i+1 to n-1
     */

    public static int[] nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums;
        }
        int i = n-1;
        for(int j = n-2; j >=0; j--){
            if(nums[j+1]>nums[j]){
                i = j;
                break;
            }
        }
        if(i == n-1){
            Arrays.sort(nums);
            return nums;
        }
        int nextMax = Integer.MAX_VALUE;
        int j = i+1;
        int swapIdx = j;
        nextMax = Math.min(nextMax, nums[swapIdx]);
        while(j<n){
            if(nums[j] < nextMax && nums[j] > nums[i]){
                nextMax = nums[j];
                swapIdx = j;
            }
            j++;
        }

        int temp = nums[i];
        nums[i] = nums[swapIdx];
        nums[swapIdx] = temp;

        Arrays.sort(nums, i+1, n);
        return nums;

    }
}
