package leetcode;

public class LC75 {

    public static void main(String[] args) {
        sortColors(new int[] {2,0,2,1,1,0});
    }
    public static void sortColors(int[] nums) {
        int[] count = new int[3];

        for(int i: nums){
            count[i]++;
        }

        int idx = 0;
        for(int i = 0; i<count.length; i++){
            int j = count[i];
            while(j > 0){
                nums[idx] = i;
                idx++;
                j--;
            }

        }

    }
}
