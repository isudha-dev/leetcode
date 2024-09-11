package leetcode;

public class LC2220 {

    public static void main(String[] args) {
        minBitFlips(10, 7);
    }

    public static int minBitFlips(int start, int goal) {

        // get the ith bit of start
        /*
            left shift & 1. if 1 then its 1 else 0

            find bits in a num
            0-1     1
            2-3     2
            4-7     3
            8-15    4
            16-31   5

            1 << 1 = 1
            1 << 2 = 2
            1 << 3 = 4
            1 << 4 = 8
            1 << 5 = 16

            for(int l = 1; l<32; l++) {
                if(start >= (1 << l) && start < (1 << l+1)) {
                    bitCount = l;
                    break;
                }
            }

        */

        // get the ith bit of goal

        // if they differ, add to count

        // do this for maxBitLen(start, end)
        int bitsStart = 1;
        int bitsGoal = 1;

        for(int l = 1; l<33; l++) {
            if(start >= (1 << l) && start < (1 << l+1)) {
                bitsStart = l;
            }
            if(goal >= (1 << l) && goal < (1 << l+1)) {
                bitsGoal = l;
            }
        }

        int count = 0;
        for(int l = 1; l<33; l++) {
            // left shift & 1. if 1 then its 1 else 0
            int bitStart = start & 1;
            int bitGoal = goal & 1;
            if(bitStart != bitGoal) {
                count++;
            }
            start = start >> 1;
            goal = goal >> 1;
            if(start == 0 && goal == 0) {
                break;
            }
        }
        return count;

    }
}
