package leetcode;

import java.util.*;

public class LC216 {

    public static void main(String[] args) {
        combinationSum3(3, 9);
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        Set<List<Integer>> ans = new HashSet<>();
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        recur(0, candidates, k, n, new ArrayList<>(), ans);

        List<List<Integer>> list = new ArrayList<>();
        for(List<Integer> lst: ans){
            list.add(lst);
        }

        return list;
        // 1, 4
        /*
            1,6
            0,6
         */
    }

    public static void recur(int i, int[] candidates, int k, int currSum, List<Integer> temp, Set<List<Integer>> ans){
        if(i == candidates.length){
            if(temp.size() == k && currSum == 0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(temp.size() == k && currSum == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(currSum < 0){
            return;
        }

        int num = candidates[i];
        temp.add(num);
        recur(i+1, candidates, k, currSum-num, temp, ans);
        temp.remove(temp.size()-1);

        recur(i+1, candidates, k, currSum, temp, ans);
    }
}
