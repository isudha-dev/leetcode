package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LC2053 {
    public static void main(String[] args) {
        System.out.println(kthDistinct(new String[]{"a","b","a"}, 3));
    }
    public static String kthDistinct(String[] arr, int k) {
        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for(String s: arr){
            if(!map.containsKey(s)){
                q.add(s);
            }
            map.put(s, map.getOrDefault(s, 0)+1);
        }

        String ans = "";
        for(int i = 0; i<k-1; i++){
            while(!q.isEmpty() && map.get(q.peek()) != 1){
                q.poll();
            }
            q.poll();
        }

        while(!q.isEmpty() && map.get(q.peek()) != 1){
            q.poll();
        }

        return !q.isEmpty() ? q.poll() : "";

    }
}
