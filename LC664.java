package leetcode;

// https://leetcode.com/problems/strange-printer/?envType=daily-question&envId=2024-08-21

public class LC664 {
    public static void main(String[] args) {
        strangePrinter("aba");
    }
    public static int strangePrinter(String s) {
        String newS = removeDuplicate(s);
        return minimumTurns(0, newS.length()-1, newS, new int[newS.length()][newS.length()]);
    }

    public static String removeDuplicate(String s){
        if(s.length() == 1){
            return s;
        }

        char c = s.charAt(0);
        if(c == s.charAt(1)){
            int i = 1;
            while(i < s.length() && s.charAt(i) == c){
                i++;
            }
            return removeDuplicate(s.substring(i-1, s.length()));
        } else {
            String temp = removeDuplicate(s.substring(1, s.length()));
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            sb.append(temp);
            return sb.toString();
        }


    }

    public static int minimumTurns(int start, int end, String s, int[][] dpArr) {
        if(start > end)
            return 0;

        if(start == end)
            return 1;

        if(dpArr[start][end] != 0){
            return dpArr[start][end];
        }

        int minTurns = 1 + minimumTurns(start+1, end, s, dpArr);

        char c = s.charAt(start);
        for(int i = start+1; i<=end; i++){
            if(s.charAt(i) == c){
                int turnsWithMatch = minimumTurns(start, i-1, s, dpArr) + minimumTurns(i+1, end, s, dpArr);
                minTurns = Math.min(minTurns, turnsWithMatch);
            }
        }

        dpArr[start][end] = minTurns;
        return minTurns;
    }
}
