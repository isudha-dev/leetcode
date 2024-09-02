package leetcode;

import java.util.Arrays;

public class LC88 {
    public static void main(String[] args) {
        merge(new int[] {1,2,4,5,6,0}, 5, new int[] {3}, 1);
    }
    public static void merge(int[] a, int m, int[] b, int n) {
        int count = 0;
        int l1 = m;
        int l2 = n;
        int p1 = 0, p2 = 0;
        while(count != l1 && p1<l1 && p2<l2){
            if(a[p1] <= b[p2]){
                count++;
                p1++;
            } else {
                count++;
                p2++;
            }
        }
        if(p1 == 0 && p2 == 0){
            if(n != 0) {
                for (int i = 0; i < n; i++) {
                    a[i] = b[i];
                }
                return;
            }
            else
                return;
        }

        p2 = 0;
        while (p1 < l1 && p2 < l2){
            int temp = a[p1];
            a[p1] = b[p2];
            b[p2] = temp;
            p2++;
            p1++;
        }

        int j = 0;
        for(int i = m; i<a.length; i++){
            a[i] = b[j];
            j++;
        }
        Arrays.sort(a);

    }
}
