package leetcode;

public class LC1945 {

    public static void main(String[] args) {
        getLucky("vbyytoijnbgtyrjlsc", 2);
    }
    public static int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()) {
            int i = c - 'a' + 1;
            sb.append(i);
        }

        s = sb.toString();
        while (k > 0) {
            long sum = 0;
            for (char c: s.toCharArray()) {
                int i = c-'0';
                sum+=i;
            }

            s = String.valueOf(sum);
            k--;
        }

        return Integer.parseInt(s);

    }

    public static int getDigitSum(int n) {
        int sum = 0;

        while(n > 0) {
            sum += n%10;
            n = n/10;
        }

        return sum;
    }
}
