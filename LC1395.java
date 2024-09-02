package leetcode;

import java.util.Collections;
import java.util.HashMap;

public class LC1395 {
    // count number of teams

    public static void main(String[] args) {
        System.out.println(numTeams(new int[]{1,2,3,4}));
    }
    public static int numTeams(int[] rating) {
        HashMap<Integer, Integer> incMapL = new HashMap<>(); // smallerL
        HashMap<Integer, Integer> incMapR = new HashMap<>(); // largerR
        HashMap<Integer, Integer> decMapL = new HashMap<>(); // largerL
        HashMap<Integer, Integer> decMapR = new HashMap<>(); // smallerR

        int n = rating.length;
        for (int i = 0; i < n; i++) {
            int num = rating[i];
            incMapL.put(num, 0);
            incMapR.put(num, 0);
            decMapL.put(num, 0);
            decMapR.put(num, 0);
        }

        for (int i = 1; i < n-1; i++) {
            int num1 = rating[i];
            for (int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }
                int num2 = rating[j];

                // on left side
                // find larger element on left
                // find smaller element on left
                if(i > j){
                    if(num2 < num1){
                        incMapL.put(num1, incMapL.getOrDefault(num1, 0)+1);
                    } else {
                        decMapL.put(num1, decMapL.getOrDefault(num1, 0)+1);
                    }
                }

                // on right side
                // find smaller element on right
                // find larger element on right
                if(i < j){
                    if(num2 > num1){
                        incMapR.put(num1, incMapR.getOrDefault(num1, 0)+1);
                    } else {
                        decMapR.put(num1, decMapR.getOrDefault(num1, 0)+1);
                    }
                }
            }

        }

        int ans = 0;
        for (int i = 1; i < n-1; i++) {
            int num = rating[i];
            // inc sequence
            ans = ans + incMapL.get(num)*incMapR.get(num);

            // dec sequence
            ans = ans + decMapL.get(num)*decMapR.get(num);
        }

        return ans;

    }
}
