package leetcode;

public class LC4 {

    public static void main(String[] args) {
        findMedianSortedArrays(new int[] {1,2}, new int[] {3,4});
    }

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int len = A.length + B.length;

        int targetIndex = len / 2;

        int index = 0;
        int p1 = 0, p2 = 0;
        float value = 0;
        float prevValue = 0;
        while (index <= targetIndex && p1 < A.length && p2 < B.length) {
            prevValue = value;
            if (A[p1] <= B[p2]) {
                value = A[p1];
                p1++;
            } else {
                value = B[p2];
                p2++;
            }
            if (len % 2 == 0 && index == targetIndex) {
                return  (value + prevValue) / 2;
            }
            index++;
        }

        while (index <= targetIndex && p1 < A.length) {
            prevValue = value;
            value = A[p1];
            p1++;
            index++;
        }

        while (index <= targetIndex && p2 < B.length) {
            prevValue = value;
            value = B[p2];
            p2++;
            index++;
        }

        if (len % 2 == 0) {
            return  (value + prevValue) / 2;
        }

        return value;
    }
}
