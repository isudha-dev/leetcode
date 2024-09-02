package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SecondMinimum {

    static class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2}};
        System.out.println(secondMinimum(2, edges, 3, 2));
    }

    public static int secondMinimum(int n, int[][] edges, int time, int change) {

        List<ArrayList<Integer>> adjList = IntStream.range(0, n+1)
                .mapToObj(i -> new ArrayList<>(Collections.nCopies(0,0)))
                .collect(Collectors.toList());

        for (int[] arr: edges){
            int src = arr[0];
            int dest = arr[1];
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.b));
        pq.add(new Pair(1, 0));

        int[] dist1 = new int[n+1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        dist1[1] = 0;

        int[] dist2 = new int[n+1];
        Arrays.fill(dist2, Integer.MAX_VALUE);

        int[] freq = new int[n+1];
        Arrays.fill(freq, 0);


        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int node = top.a;
            int nodeTime = top.b;
            freq[node]++;

            if(node == n && freq[node] == 2){
                return nodeTime;
            }

            for (int nei : adjList.get(node)){
                int timeTaken = nodeTime;

                if ((timeTaken / change) % 2 == 1) {
                    timeTaken = change * (timeTaken / change + 1) + time;
                } else {
                    timeTaken = timeTaken + time;
                }

                if(dist1[nei] > timeTaken){
                    dist2[nei] = dist1[nei];
                    dist1[nei] = timeTaken;
                    pq.add(new Pair(nei, timeTaken));
                } else if(dist2[nei] > timeTaken && dist1[nei] != timeTaken){
                    dist2[nei] = timeTaken;
                    pq.add(new Pair(nei, timeTaken));
                }
            }
        }

        return 0;

    }
}
