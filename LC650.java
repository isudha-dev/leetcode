package leetcode;

public class LC650 {
    public static void main(String[] args) {
        System.out.println(minSteps(21));
    }

    public static int findPrimeDivisor(int n) {
        if((n&1) != 1){
            return 2;
        }

        for (int k = 2; k < n; k++) {
            if (n % k == 0) {
                return k;
            }
        }
        return n;
    }


    public static int minSteps(int n) {
        if(n == 1)
            return 0;

        if(n == 2)
            return 2;

        int div = findPrimeDivisor(n);

        if(div == n){
            return n;
        }

        return div + minSteps(n/div);

    }
}
