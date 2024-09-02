package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1514 {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[9][2];
        edges[0] = new int[] {2,3};
        edges[1] = new int[] {1,2};
        edges[2] = new int[] {3,4};
        edges[3] = new int[] {1,3};
        edges[4] = new int[] {1,4};
        edges[5] = new int[] {0,1};
        edges[6] = new int[] {2,4};
        edges[7] = new int[] {0,4};
        edges[8] = new int[] {0,2};

        double[] succProb = new double[] {0.06,0.26,0.49,0.25,0.2,0.64,0.23,0.21,0.77};

        maxProbability(n, edges, succProb, 0, 3);
    }

    public static List<List<Integer>> createAdjList(int n, int[][] edges) {
//        int n = edges.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        return adjList;
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Integer>> paths = new ArrayList<>();
        List<List<Integer>> adjList = createAdjList(n, edges);
        boolean[] visited = new boolean[n];

        dfs(start_node, end_node, adjList, visited, new ArrayList<>(), paths);

        HashMap<String, Double> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            String s = edges[i][0]+"-"+edges[i][1];
            map.put(s, succProb[i]);
            s = edges[i][1]+"-"+edges[i][0];
            map.put(s, succProb[i]);
        }

        double maxProb = 0.0;
        for (List<Integer> currPath: paths) {
            double probability = 1;
            for (int i = 1; i< currPath.size(); i++) {
                String s = currPath.get(i-1)+"-"+currPath.get(i);
                if(map.containsKey(s)){
                    probability *= map.get(s);
                } else {
                    s = currPath.get(i)+"-"+currPath.get(i-1);
                    if(map.containsKey(s)) {
                        probability *= map.get(s);
                    }
                }
            }
            maxProb = Math.max(maxProb, probability);
        }

        return maxProb;
    }

    public static void dfs(int source, int dest, List<List<Integer>> adjList, boolean[] visited, List<Integer> currPath, List<List<Integer>> paths) {
        visited[source] = true;
        currPath.add(source);

        if(source == dest) {
            paths.add(new ArrayList<>(currPath));
        } else {
            for(int neighbour: adjList.get(source)){
                if(!visited[neighbour]) {
                    dfs(neighbour, dest, adjList, visited, currPath, paths);
                }
            }
        }
        visited[source] = false;
        currPath.remove(currPath.size()-1);
    }
}
