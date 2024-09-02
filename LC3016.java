package leetcode;

import java.util.*;

public class LC3016 {
    public static void main(String[] args) {
        System.out.println( minimumPushes("aabbccddeeffgghhiiiiii"));
    }
    public static int minimumPushes(String word) {
        TreeMap<Character, Integer> map = new TreeMap<>();

        for(Character c: word.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) +1);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1]-a[1]);
        map.entrySet().forEach(entry -> q.add(new int[] {entry.getKey(), entry.getValue()}));

        int sum = 0;

        int sets = map.size() / 8;
        if(map.size() % 8 != 0){
            sets++;
        }
        for (int i = 1; i <= sets ; i++) {
            int end = Math.min(8, q.size());
            for (int j = 1; j <= end ; j++) {
                int[] arr = q.poll();
                sum += (i*arr[1]);
            }
        }


        return sum;

    }
}
