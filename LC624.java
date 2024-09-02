package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/maximum-distance-in-arrays/description/?envType=daily-question&envId=2024-08-16
public class LC624 {
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(List.of(1,2,3));
        arrays.add(List.of(4,5));
        arrays.add(List.of(1,2,3));
        maxDistance(arrays);
    }
    public static int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDist = 0;

        for(int i = 1; i<arrays.size(); i++){
            int n = arrays.get(i).size();
            int low = arrays.get(i).get(0);
            int high = arrays.get(i).get(n-1);

            maxDist = Math.max(maxDist, Math.abs(high-min));
            maxDist = Math.max(maxDist, Math.abs(max-low));
            min = Math.min(min, low);
            max = Math.max(max, high);
        }

        return maxDist;
    }
}
