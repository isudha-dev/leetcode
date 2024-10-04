package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC2707 {

    public static void main(String[] args) {
        System.out.println(minExtraChar("dwmodizxvvbosxxw", new String[] {"ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"}));

    }
    public static int minExtraChar(String s, String[] dictionary) {

        HashSet<String> set = new HashSet<>(List.of(dictionary));
        int[] arr = new int[s.length()];

        for(String str: set) {
            if(s.contains(str)) {
                boolean allMatched = false;
                int i1 = 0, i2 = 0;
                while (!allMatched && i1 < s.length() && i2 < str.length()) {
                    char c1 = s.charAt(i1);
                    char c2 = str.charAt(i2);
                    if(c1 != c2) {
                        i1++;
                    } else {
                        while (i1 < s.length() && i2 < str.length() && c1 == c2) {
                            i1++;
                            i2++;
                            if(i2 == str.length()) {
                                int start = i1-str.length();
                                for (int i = start; i < i2+start; i++) {
                                    arr[i] = 1;
                                }
                                allMatched = true;
                                break;
                            }
                            c1 = s.charAt(i1);
                            c2 = str.charAt(i2);
                        }
                    }
                }
            }
        }


        return (int) Arrays.stream(arr).filter(i -> i == 0).count();

    }

}
