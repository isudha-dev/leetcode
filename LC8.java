package leetcode;

public class LC8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }

    public static int myAtoi(String s) {

        int num = 0;
        boolean isNeg = false;

        int idx = 0;
        while(idx < s.length()) {
            if(s.charAt(idx) == ' ')
                idx++;
            else
                break;
        }

        if (idx < s.length()) {
            if(s.charAt(idx) == '-') {
                isNeg = true;
                idx++;
            } else if(s.charAt(idx) == '+') {
                isNeg = false;
                idx++;
            }
        }

        while(idx < s.length()) {
            if(s.charAt(idx) == '0')
                idx++;
            else
                break;
        }

        while(idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            if(idx != s.length() && num > Integer.MAX_VALUE/10){
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            char c = s.charAt(idx);
            num = num*10 + (c - '0');
            if(num < 0)
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            idx++;



//            if(isNeg) {
//                if(idx != s.length() && Integer.MIN_VALUE/10 > (num*-1)) {
//                    return Integer.MIN_VALUE;
//                }
//            } else {
//                if(idx != s.length() && Integer.MAX_VALUE/10 < num) {
//                    return Integer.MAX_VALUE;
//                }
//            }
        }

        return isNeg ? num*-1 : num;


    }
}
