package leetcode;/*
 * @lc app=leetcode id=520 lang=java
 *
 * [520] Detect Capital
 */

// @lc code=start
class DetectCapital {

    public static void main(String[] args) {
        detectCapitalUse("ffffffffffffffffffffF");
    }

    public static boolean detectCapitalUse(String word) {
        int countCaps = 0;

        for (char c : word.toCharArray()) {
            if (c >= 65 && c <= 90) {
                countCaps++;
            }
        }

        int len = word.length();

        if (len == countCaps)
            return true;
        else if (countCaps == 0)
            return true;

        if (countCaps == 1 && word.charAt(0) >= 65 && word.charAt(0) <= 90)
            return true;

        return false;
    }
}
// @lc code=end
