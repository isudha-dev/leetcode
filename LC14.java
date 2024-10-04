package leetcode;

import java.util.Arrays;

public class LC14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }
    public static String longestCommonPrefix(String[] strs) {

        int minLen = Arrays.stream(strs).mapToInt(i -> i.length()).min().getAsInt();

        int p1 = 0;
        boolean end = false;
        while (p1 < minLen) {
            char c = strs[0].charAt(p1);
            for(int i = 1; i < strs.length; i++) {
                if(strs[i].charAt(p1) != c){
                    end = true;
                    break;
                }
                if(i == strs.length-1) {
                    p1++;
                }
            }
            if (end) {
                break;
            }
        }


        return strs[0].substring(0, p1);
    }
}
