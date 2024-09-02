package leetcode;

public class LC1653 {

    public static void main(String[] args) {
        // "ababaaaabbbbbaaababbbbbbaaabbaababbabbbbaabbbbaabbabbabaabbbababaa"
        // e 25 a 28
        System.out.println(minimumDeletions("ababaaaabbbbbaaababbbbbbaaabbaababbabbbbaabbbbaabbabbabaabbbababaa"));
    }
    public static int minimumDeletions(String s) {
        int n = s.length();

        // b's before
        int[] bBefore = new int[n];
        bBefore[0] = 0;
        for (int i = 1; i < n; i++) {
            if(s.charAt(i-1) == 'b')
                bBefore[i] = bBefore[i-1] + 1;
            else
                bBefore[i] = bBefore[i-1];
        }

        // a's after
        int[] aAfter = new int[n];
        aAfter[n-1] = 0;
        for (int i = n-2; i >=0 ; i--) {
            if(s.charAt(i+1) == 'a')
                aAfter[i] = aAfter[i+1] + 1;
            else
                aAfter[i] = aAfter[i+1];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currSum = bBefore[i] + aAfter[i];
            min = Math.min(min, currSum);
        }

        return min;
    }
}
