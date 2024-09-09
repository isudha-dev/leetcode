package leetcode;

public class LC1689 {
    public static void main(String[] args) {
        minPartitions("345");
    }

    public static int minPartitions(String s) {
        int n = 0;

        for(char c: s.toCharArray()) {
            int n1 = c - '0';
            n = Math.max(n1, n);
        }

        return n;

    }
}
