package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC986 {

    public static void main(String[] args) {
        intervalIntersection(new int[][] {{0,2}, {5,10}, {13,23}, {24,25}}, new int[][] {{1,5}, {8,12}, {15,24}, {25,26}});
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstIdx = 0;
        int secondIdx = 0;

        int firstLen = firstList.length;
        int secondLen = secondList.length;

        List<List<Integer>> ans = new ArrayList<>();

        while(firstIdx < firstLen && secondIdx < secondLen) {
            if(secondList[secondIdx][1] < firstList[firstIdx][0]) {
                // no overlap, second comes before
                secondIdx++;
                continue;
            }

            if(firstList[firstIdx][1] < secondList[secondIdx][0]) {
                firstIdx++;
                continue;
            }

            List<Integer> list = new ArrayList<>();

            int l1 = Math.max(firstList[firstIdx][0], secondList[secondIdx][0]);
            int l2 = Math.min(firstList[firstIdx][1], secondList[secondIdx][1]);

            ans.add(new ArrayList<>(List.of(l1, l2)));

            if(l2 == firstList[firstIdx][1]) {
                firstIdx++;
            }

            if(l2 == secondList[secondIdx][1]) {
                secondIdx++;
            }

        }

        int idx = 0;
        int[][] ansArray = new int[ans.size()][];
        for(List<Integer> list : ans) {
            ansArray[idx++] = new int[] {list.get(0), list.get(1)};
        }

        return ansArray;
    }
}
