package leetcode;

import java.util.*;

public class LC39 {

    public static void main(String[] args) {
        combinationSum1(new int[] {2,3,6,7}, 7);
    }
    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(candidates);
        recur(0, candidates, target, new ArrayList<>(), ans);

        List<List<Integer>> list = new ArrayList<>();
        for(List<Integer> lst: ans){
            list.add(lst);
        }

        return list;
    }

    public static void recur(int i, int[] candidates, int currSum, List<Integer> temp, Set<List<Integer>> ans){
        if(i == candidates.length){
            if(currSum == 0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(currSum < 0){
            return;
        }

        int num = candidates[i];
        temp.add(num);
        recur(i, candidates, currSum-num, temp, ans);
        temp.remove(temp.size()-1);

        recur(i+1, candidates, currSum, temp, ans);

    }
}
