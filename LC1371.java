package leetcode;

import java.util.*;


public class LC1371 {
    public static void main(String[] args) {
        findTheLongestSubstring("leetcodeisgreat");
    }

    public static int findTheLongestSubstring(String s) {
        int n = s.length();

        int[] charMap = new int[n];

        int idx = 0;
        for(char c: s.toCharArray()) {
            if(c == 'a') {
                charMap[idx++] = 1;
            } else if(c == 'e') {
                charMap[idx++] = 2;
            } else if(c == 'i') {
                charMap[idx++] = 4;
            } else if(c == 'o') {
                charMap[idx++] = 8;
            } else if(c == 'u') {
                charMap[idx++] = 16;
            } else {
                charMap[idx++] = 0;
            }
        }

        int[] xorMap = new int[32];
        Arrays.fill(xorMap, -1);

        int[] prefixXor = new int[n+1];
        prefixXor[0] = 0;

        int maxLen = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            prefixXor[i] = prefixXor[i-1] ^ charMap[i-1];
            if(xorMap[prefixXor[i]] == -1) {
                xorMap[prefixXor[i]] = i;
            } else {
                int currLen = i - xorMap[prefixXor[i]] +1;
                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;

    }
}
