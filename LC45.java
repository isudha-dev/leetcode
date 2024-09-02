package leetcode;

public class LC45 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,0,1,4}));
    }
    public static int jump(int[] nums) {
        /*
        2 3 1 1 4
        2 1 2 1 0

        1,2,1,1,1
        3 2 2 1 0

        1,2,3,1,1,1
        3 2 1 2 1 0
        */
        int n = nums.length;
        int[] minJump = new int[n];
        minJump[n-1] = 0;
        for(int i = n-2; i>=0 ; i--){
            int distToEnd = n-1-i; //
            if(nums[i] >= distToEnd){
                minJump[i] = 1;
            } else {
                int maxJum = i+nums[i];
                int minJumpFromI = Integer.MAX_VALUE-1;
                for (int j = i+1; j <=maxJum ; j++) {
                    minJumpFromI = Math.min(minJumpFromI, minJump[j]+1);
                }
                minJump[i] = minJumpFromI;
            }
        }

        return minJump[0];
    }
}
