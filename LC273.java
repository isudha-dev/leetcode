package leetcode;

import java.util.HashMap;

public class LC273 {

    public static void main(String[] args) {
        System.out.println(numberToWords(1000));
    }
    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder ans = new StringBuilder();
        int batchIndx = 0;
        while (num > 0) {
            if (num % 1000 != 0){
                StringBuilder batchAns = processBatch(num % 1000, batchIndx);
                ans.insert(0, batchAns);
            }
            num /= 1000;
            batchIndx++;
        }
        return ans.toString().trim();
    }
    private static StringBuilder processBatch(int currBatch, int batchIndx){
        String[] thousandsAndBeyond = {"", "Thousand", "Million", "Billion"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        StringBuilder batchAns = new StringBuilder();
        if (currBatch >= 100) {
            int hunsIndx = currBatch / 100;
            batchAns.append(ones[hunsIndx]).append(" Hundred ");
            currBatch %= 100;
        }
        if (currBatch >= 20) {
            int tensIndx = currBatch / 10;
            batchAns.append(tens[tensIndx]).append(" ");
            currBatch %= 10;
        }
        if (currBatch > 0) {
            int onesIndx = currBatch;
            batchAns.append(ones[onesIndx]).append(" ");
        }
        batchAns.append(thousandsAndBeyond[batchIndx]).append(" ");
        return batchAns;
    }
}
