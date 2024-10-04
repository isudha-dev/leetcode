package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LC539 {

    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:00");
        timePoints.add("01:00");
        timePoints.add("05:00");
        findMinDifference(timePoints);
    }

    public static int findMinDifference(List<String> timePoints) {

        Comparator comp = (Comparator<String>) (o1, o2) -> {
            String[] s1 = o1.split(":");
            String[] s2 = o2.split(":");
            if(!s1[0].equals(s2[0])) {
                return Integer.compare(Integer.parseInt(s1[0]), Integer.parseInt((s2[0])));
            } else {
                return Integer.compare(Integer.parseInt(s1[1]), Integer.parseInt((s2[1])));
            }
        };

        Collections.sort(timePoints, comp);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < timePoints.size() - 1; i++) {
            List<Integer> s1 = Arrays.stream(timePoints.get(i).split(":")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            List<Integer> s2 = Arrays.stream(timePoints.get(i+1).split(":")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            int min1 = s1.get(0) * 60 + s1.get(1);
            int min2 = s2.get(0) * 60 + s2.get(1);

            minDiff = Math.min(minDiff, min2-min1);
        }

        List<Integer> s1 = Arrays.stream(timePoints.get(0).split(":")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        List<Integer> s2 = Arrays.stream(timePoints.get(timePoints.size()-1).split(":")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        int min1 = (s1.get(0)+24) * 60 + s1.get(1);
        int min2 = s2.get(0) * 60 + s2.get(1);
        minDiff = Math.min(minDiff, min1-min2);

        return minDiff;

    }

}
