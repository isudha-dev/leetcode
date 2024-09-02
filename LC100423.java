package leetcode;

public class LC100423 {

    public static void main(String[] args) {
        System.out.println(generateKey(987, 879, 798));
    }
    public static int generateKey(int num1, int num2, int num3) {
        String s1 = String.valueOf(num1);
        String s2 = String.valueOf(num2);
        String s3 = String.valueOf(num3);

        StringBuilder sb = new StringBuilder();

        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        int minLen = Math.min(Math.min(n1, n2), n3);

        if(minLen == 1) {
            sb.append("000");
        } else if (minLen == 2) {
            sb.append("00");
        } else if (minLen == 3) {
            sb.append("0");
        }

        if(n1 < 4) {
            if(n1 == 1) {
                s1 = "000"+s1;
            } else if (n1 == 2) {
                s1 = "00" + s1;
            } else if (n1 == 3) {
                s1 = "0" + s1;
            }
        }

        if(n2 < 4) {
            if(n2 == 1) {
                s2 = "000"+s2;
            } else if (n2 == 2) {
                s2 = "00" + s2;
            } else if (n2 == 3) {
                s2 = "0" + s2;
            }
        }

        if(n3 < 4) {
            if(n3 == 1) {
                s3 = "000"+s3;
            } else if (n3 == 2) {
                s3 = "00" + s3;
            } else if (n3 == 3) {
                s3 = "0" + s3;
            }
        }

        int n = sb.length();
        for (int i = n; i < 4 ; i++) {
            int i1 = s1.charAt(i) - '0';
            int i2 = s2.charAt(i) - '0';
            int i3 = s3.charAt(i) - '0';

            int min = Math.min(Math.min(i1, i2), i3);
            sb.append(min);
        }

        return Integer.valueOf(sb.toString());
    }
}
