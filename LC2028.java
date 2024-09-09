package leetcode;

public class LC2028 {

    public static void main(String[] args) {
        int[] rolls = new int[] {4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3};
        missingRolls(rolls, 2, 53);
    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;

        for(int i: rolls) {
            sum += i;
        }

        int m =rolls.length;
        int prod = mean * (n+m);

        int remain = prod - sum;
        if(remain < 0 || remain < n) {
            return new int[] {};
        }

        int min = remain / n;
        int mod = remain % n;
        if(min > 6 || (min == 6 && mod != 0))
            return new int[] {};
        else {
            int[] arr = new int[n];
            for(int i = 0; i<n; i++) {
                arr[i] = min;
            }
            if(mod != 0) {
                int idx = 0;
                while(mod > 0) {
                    int toAdd = 6-arr[idx];
                    toAdd = Math.min(toAdd, mod);
                    arr[idx] = arr[idx] + toAdd;
                    mod -= toAdd;
                    idx++;
                }
            }
            return arr;
        }

    }
}
