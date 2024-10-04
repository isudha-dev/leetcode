package leetcode;

import java.util.HashMap;

public class LC13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
    public static int romanToInt(String s) {
        /*
        IV - 4
        IX - 9
        XL - 40
        XC - 90
        CD - 400
        CM - 900
        I  - 1
        V  - 5
        X  - 10
        L  - 50
        C  - 100
        D  - 500
        M  - 1000
        */

        HashMap<String, Integer> map = new HashMap<>();
        map.put("IV", 4);
        map.put("IX", 4);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        map.put("IV", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        int idx = 0;
        int num = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if(c == 'I') {
                if(idx < s.length()-1) {
                    char c2 = s.charAt(idx+1);
                    if(c2 == 'V') {
                        num += 4;
                        idx+=2;
                        continue;
                    } else if (c2 == 'X') {
                        num += 9;
                        idx+=2;
                        continue;
                    }
                }
                num += 1;
            } else if (c == 'X') {
                if (idx < s.length() - 1) {
                    char c2 = s.charAt(idx + 1);
                    if (c2 == 'L') {
                        num += 40;
                        idx+=2;
                        continue;
                    } else if (c2 == 'C') {
                        num += 90;
                        idx+=2;
                        continue;
                    }
                }
                num += 10;
            } else if (c == 'C') {
                if (idx < s.length() - 1) {
                    char c2 = s.charAt(idx + 1);
                    if (c2 == 'D') {
                        num += 400;
                        idx+=2;
                        continue;
                    } else if (c2 == 'M') {
                        num += 900;
                        idx+=2;
                        continue;
                    }
                }
                num += 100;
            } else if ( c == 'V') {
                num += 5;
            } else if ( c == 'L') {
                num += 50;
            } else if ( c == 'D') {
                num += 500;
            } else {
                num += 1000;
            }
            idx++;
        }

        return num;

    }
}
