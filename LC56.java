package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC56 {
    public static List<List<Integer>> mergeIntervals(List<List<Integer>> intervals){
        List<List<Integer>> ans = new ArrayList<>();
        Collections.sort(intervals, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if(o1.get(0) != o2.get(0)){
                    return o1.get(0)-o2.get(0);
                } else {
                    return o1.get(1)-o2.get(1);
                }
            }
        });
        int start = intervals.get(0).get(0);
        int end = intervals.get(0).get(1);
        ans.add(new ArrayList<>(List.of(start, end)));
        for(int i = 1; i< intervals.size(); i++){
            int newStart = intervals.get(i).get(0);
            if(newStart <= end){
                // intervals will be combined
                end = Math.max(end, intervals.get(i).get(1));
                ans.get(ans.size()-1).set(1, end);
            } else {
                // add to ans
                start = intervals.get(i).get(0);
                end = intervals.get(i).get(1);
                ans.add(new ArrayList<>(List.of(start, end)));
            }
        }

        return ans;

    }
}
