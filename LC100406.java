package leetcode;

//https://leetcode.com/contest/biweekly-contest-138/problems/find-the-count-of-good-integers/
public class LC100406 {
    public static long countGoodIntegers(int n, int k) {
        int start = 0;
        long end = 0;

        if(n == 1) {
            start = 1;
            end = 9;
        }
        if(n == 2) {
            start = 10;
            end = 19;
        }
        if(n == 3) {
            start = 100;
            end = 999;
        }
        if(n == 4) {
            start = 1000;
            end = 9999;
        }
        if(n == 5) {
            start = 10000;
            end = 99999;
        }
        if(n == 6) {
            start = 100000;
            end = 999999;
        }
        if(n == 7) {
            start = 1000000;
            end = 9999999;
        }
        if(n == 8) {
            start = 10000000;
            end = 99999999;
        }
        if(n == 9) {
            start = 100000000;
            end = 999999999;
        }
        if(n == 10) {
            start = 1000000000;
            end = 9999999999l;
        }

        while (start % k != 0) {
            start++;
        }


        for (int i = start; i <= end; i += k) {
        }


        return 0;

    }
}
