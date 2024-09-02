package leetcode;

import java.util.HashMap;

public class LC5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aa"));
    }
    public static String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1)
            return s;
        // consider each char as mid of palindrome and traverse in opposite dir to find len
        int maxLen = 0;
        String output = "";
        for (int i = 0; i < n; i++) {
            // odd len palindrome
            int p1 = i-1, p2 = i+1;
            while (p1 >=0 && p2<n && s.charAt(p1)==s.charAt(p2)) {
                int currLen = p2-p1+1;
                if(currLen > maxLen) {
                    maxLen = currLen;
                    output = s.substring(p1, p2+1);
                }
                p1--;
                p2++;
            }

            // even len palindrome
            p1 = i; p2 = i+1;
            while (p1 >=0 && p2<n && s.charAt(p1)==s.charAt(p2)) {
                int currLen = p2-p1+1;
                if(currLen > maxLen) {
                    maxLen = currLen;
                    output = s.substring(p1, p2+1);
                }
                p1--;
                p2++;
            }
        }
        if(maxLen == 0)
            return s.substring(0,1);

        return output;
    }
}
