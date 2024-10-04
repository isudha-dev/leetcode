package leetcode;

public class LC10 {

    public static void main(String[] args) {
        System.out.println(isMatch("ab", ".*c"));
    }

    public static boolean isMatch(String s, String p) {
        int i = 0, j = 0;

        while(i < s.length() && j < p.length()) {
            char c1 = s.charAt(i);
            char c2 = p.charAt(j);
            if(c2 == c1 || c2 == '.') {
                i++;
                j++;
            } else if (c2 == '*') {
                if(j-1 < 0) {
                    return false;
                }
                char c3 = p.charAt(j-1);
                if(c3 == '.') {
                    if(j == p.length()-1) {
                        return true;
                    } else {
                        j++;
                        while (s.charAt(i) != p.charAt(j)) {
                            i++;
                        }
                    }
                    return true;
                } else if (c3 == c1) {
                    i++;
                    while (i < s.length() && s.charAt(i) == c3) {
                        i++;
                    }
                }
                j++;
            } else {
                j++;
            }
        }

        return i == s.length() ? true : false;

    }
}
