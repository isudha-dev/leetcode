package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC874 {

    public static void main(String[] args) {
        System.out.println(robotSim(new int[] {-2,-1,8,9,6}, new int[][] {{-1,3},{0,1},{-1,5},{-2,-4},{5,4},{-2,-3},{5,-1},{1,-1},{5,5},{5,2}}));
    }

    public static int robotSim(int[] commands, int[][] obstacles) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < obstacles.length; i++) {
            if(map.containsKey(obstacles[i][0])) {
                List<Integer> list = map.get(obstacles[i][0]);
                list.add(obstacles[i][1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(obstacles[i][1]);
                map.put(obstacles[i][0], list);
            }
        }

        int maxEuDistance = Integer.MIN_VALUE;

        int x = 0, y = 0;
        boolean n = true, e = false, s = false, w = false;

        for (int i = 0; i < commands.length; i++) {
            if(commands[i] == -1) {
                if(n) {
                    n = false;
                    e = true;
                } else if (e) {
                    e = false;
                    s = true;
                } else if (s) {
                    s = false;
                    w = true;
                } else if (w) {
                    w = false;
                    n = true;
                }

            } else if (commands[i] == -2) {
                if(n) {
                    n = false;
                    w = true;
                } else if (e) {
                    e = false;
                    n = true;
                } else if (s) {
                    s = false;
                    e = true;
                } else if (w) {
                    w = false;
                    s = true;
                }
            } else {
                if(n) {
                    for (int j = 0; j < commands[i]; j++) {
                        int yN = y + 1;
                        if (map.containsKey(x)) {
                            if(map.get(x).contains(yN)) {
                                break;
                            }
                        }
                        y = yN;
                        maxEuDistance = Math.max(maxEuDistance, (x*x + y*y));
                    }
                } else if (e) {
                    for (int j = 0; j < commands[i]; j++) {
                        int xN = x + 1;
                        if (map.containsKey(xN)) {
                            if(map.get(xN).contains(y)) {
                                break;
                            }
                        }
                        x = xN;
                        maxEuDistance = Math.max(maxEuDistance, (x*x + y*y));
                    }
                } else if (s) {
                    for (int j = 0; j < commands[i]; j++) {
                        int yN = y - 1;
                        if (map.containsKey(x)) {
                            if(map.get(x).contains(yN)) {
                                break;
                            }
                        }
                        y = yN;
                        maxEuDistance = Math.max(maxEuDistance, (x*x + y*y));
                    }
                } else if (w) {
                    for (int j = 0; j < commands[i]; j++) {
                        int xN = x - 1;
                        if (map.containsKey(xN)) {
                            if(map.get(xN).contains(y)) {
                                break;
                            }
                        }
                        x = xN;
                        maxEuDistance = Math.max(maxEuDistance, (x*x + y*y));
                    }
                }

            }
        }


        return maxEuDistance == Integer.MIN_VALUE ? 0 : maxEuDistance;

    }

}
