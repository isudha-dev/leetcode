package leetcode;

public class LC100399 {

    public static void main(String[] args) {
        stringHash("abcd", 2);
    }
    public static String stringHash(String s, int k) {
        int n = s.length();
        int[] ar = new int[n];

        for(int i = 0; i < n; i++) {
            ar[i] = s.charAt(i) - 'a';
        }

        StringBuilder sb = new StringBuilder();

        int idx = 0;
        while (idx < n) {
            int sum = 0;
            for (int i = 1; i <= k; i++) {
                sum += ar[idx];
                idx++;
            }
            sum %= 26;
            char ch = (char) (sum + 'a');
            sb.append(ch);
        }

        return sb.toString();
    }
}
