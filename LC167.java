package leetcode;

import java.util.Arrays;

public class LC167 {
    public static int[] twoSum2(int[] numbers, int target) {
        int[] arr = new int[2001];
        for (int i= 0; i< arr.length; i++) {
            arr[i] = 2000;
        }

        // -1000->-1 1001(0) 1->1000 = 2002
        // 0-999 1000 1001->1000
        int mid = 1000;
        for(int i= 0; i< numbers.length; i++) {
            /*  range {-3 -> 3}
                {-1, 0}
                {0, 1, 2, 3, 4, 5, 6}
                {-3,-2,-1,0, 1, 2, 3}
                {       0,1         }
             */
            if(numbers[i] != 0) {
                arr[mid + numbers[i]] = i;
            } else {
                arr[mid] = i;
            }

        }

        for(int i = 0; i<numbers.length; i++) {
            int key = target - numbers[i];
            if(key > 1000 || key < -1000) {
                continue;
            }
            if(arr[mid + key] != 2000) {
                int[] ans = new int[] {arr[key+mid]+1, i+1};
                Arrays.sort(ans);
                return ans;
            }
        }

        return null;
    }
}
