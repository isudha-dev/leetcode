package leetcode;

public class LC564 {
    /*
        special cases: power of 10
        9 -> 8
        11  -> 9
        88 -> even digit palindrome -> 77
        99 -> 101
        11011 -> 11111
        1001 -> 999

     */
    public static void main(String[] args) {
        System.out.println(nearestPalindromic("11011"));
    }
    public static String nearestPalindromic(String n) {
        if(n == "0")
            return "1";

        if(n == "11")
            return "9";

        int num = Integer.parseInt(n);
        int temp = num;
        while (temp%10 == 0){
            temp /= 10;
        }
        if(temp == 1){
            return num-1+"";
        }

        if(num % 9 == 0 && (num+1) % 10 == 0 && num != 9){
            return num+2+"";
        }

        if(((num-1) % 10) == 0 && num != 101){
            return num-2+"";
        }

        boolean isPalin = isPalindrome(n);

        int l = n.length();
        boolean isOddLen = l % 2 == 0 ? false : true;
        int mid = l/2;
        char[] chArr = n.toCharArray();

        if(isPalin){
            int k = n.charAt(mid) - '0';
            if(k == 0)
                k++;
            else
                k--;

            chArr[mid] = (char) (k + '0');
            if(!isOddLen && l>1){
                chArr[mid-1] = (char) (k + '0');
            }
            return new String(chArr);
        }

        int startIdx = isOddLen ? mid+1 : mid;
        int otherIdx = isOddLen ? startIdx-2 : startIdx-1;


        while (startIdx < l && otherIdx >= 0){
            chArr[startIdx] = chArr[otherIdx];
            startIdx++;
            otherIdx--;
        }

        return new String(chArr);
    }

    public static boolean isPalindrome(String n){
        int p1 = 0;
        int p2 = n.length()-1;

        while (p1<p2){
            if(n.charAt(p1) != n.charAt(p2))
                return false;
            p1++;
            p2--;
        }
        return true;
    }
}
