package leetcode;

import java.util.*;

public class LC947 {

    public static void main(String[] args) {
//        removeStones(new int[][] {{0,0}, {0,2}, {1,1}, {2,0}, {2,2}});
         removeStones(new int[][] {{0,0},{0,3},{1,1},{1,2},{2,1},{2,3},{2,4},{3,0},{4,1},{5,1},{5,4}});
        // removeStones(new int[][] {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}});
    }

    public static List<Integer>[] createAdjList(int[][] stones) {
        int n = stones.length;
        List<Integer>[] adjList = new List[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }

        return  adjList;
    }
    public static int removeStones(int[][] stones) {
        int n = stones.length;
        List<Integer>[] adjList = createAdjList(stones);

        boolean[] visited = new boolean[n];

        int countComponents = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                dfs(i, adjList, visited);
                countComponents++;
            }
        }

        return  n-countComponents;
    }

    public static void dfs(int idx, List<Integer>[] adjList, boolean[] visited) {
        visited[idx] = true;

        for (int k: adjList[idx]) {
            if(!visited[k])
                dfs(k, adjList, visited);
        }
    }

    public static void dfs(int r, int c, int rows, int cols, HashSet<String> valueSet, HashSet<String> visitedSet, int component){
        String s = r+"-"+c;
        visitedSet.add(s);

        // down navigation
        int rN = r+1;
        while (rN < rows){
            String sN = rN+"-"+c;
            if(!visitedSet.contains(sN) && valueSet.contains(sN))
                dfs(rN, c, rows, cols, valueSet, visitedSet, component);
            rN++;
        }

        // up
        rN = r-1;
        while (rN >= 0){
            String sN = rN+"-"+c;
            if(!visitedSet.contains(sN) && valueSet.contains(sN))
                dfs(rN, c, rows, cols, valueSet, visitedSet, component);
            rN--;
        }

        // left
        int cN = c+1;
        while (cN < cols){
            String sN = r+"-"+cN;
            if(!visitedSet.contains(sN) && valueSet.contains(sN))
                dfs(r, cN, rows, cols, valueSet, visitedSet, component);
            cN++;
        }

        // right
        cN = c-1;
        while (cN >= 0){
            String sN = r+"-"+cN;
            if(!visitedSet.contains(sN) && valueSet.contains(sN))
                dfs(r, cN, rows, cols, valueSet, visitedSet, component);
            cN--;
        }
    }
}
