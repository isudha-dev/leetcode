package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC6 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
    public static String convert(String s, int numRows) {
        List<List<Character>> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }

        int n = s.length();
        int idx = 0;
        while (idx < n) {
            for (int i = 0; i < numRows && idx < n; i++) {
                list.get(i).add(s.charAt(idx));
                idx++;
            }

            for (int i = numRows-2; i >= 1  && idx < n ; i--) {
                list.get(i).add(s.charAt(idx));
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            List<Character> currList = list.get(i);
            currList.stream().forEach(ch -> sb.append(ch));
        }

        return sb.toString();
    }
}
