package leetcode;

import java.util.*;

public class LC241 {
    static int totalCalls = 0;
    public static void main(String[] args) {
        diffWaysToCompute("2*5-7+3*2");
        System.out.println("Total calls: "+ totalCalls);

        StringBuilder sb = new StringBuilder("sdsdsd");
    }

    public static List<Integer> diffWaysToCompute1(String expression) {
        return calculate(expression, 0, expression.length()-1);
    }
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> operands = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int start = 0, end = 0;
        while (end < expression.length()) {
            while (end < expression.length() && expression.charAt(end) != '*' && expression.charAt(end) != '+' && expression.charAt(end) != '-') {
                end++;
            }
            if(end < expression.length())
                ops.add(expression.charAt(end));

            operands.add(Integer.parseInt(expression.substring(start, end)));
            start = end+1;
            end = start;

        }
        if(ops.size() == 0)
            return operands;

        ArrayList<Integer>[][] dpArr = new ArrayList[operands.size()][];
        for (int i = 0; i<operands.size(); i++) {
            dpArr[i] = new ArrayList[operands.size()];
        }


        List<Integer> ans =  calculateOpsMemoize(operands, ops, 0, operands.size()-1, dpArr);
        return ans;
    }

    public static List<Integer> calculateOpsMemoize(List<Integer> operands, List<Character> ops, int start, int end, List<Integer>[][] dpArr) {
        if(dpArr[start][end] != null) {
            return dpArr[start][end];
        }

        if(start == end) {
            List<Integer> ans = new ArrayList<>(List.of(operands.get(start)));
            dpArr[start][end] = ans;
            return ans;
        }
        if(end == start+1) {
            int o1 = operands.get(start);
            int o2 = operands.get(end);
            if(ops.get(start) == '*') {
                List<Integer> ans = new ArrayList<>(List.of(o1 * o2));
                dpArr[start][end] = ans;
                return ans;
            } else if(ops.get(start) == '+') {
                List<Integer> ans = new ArrayList<>(List.of(o1 + o2));
                dpArr[start][end] = ans;
                return ans;
            } else {
                List<Integer> ans = new ArrayList<>(List.of(o1 - o2));
                dpArr[start][end] = ans;
                return ans;
            }


        }

        totalCalls++;

        List<Integer> ansArr = new ArrayList<>();
        int newEnd = start;
        while (newEnd <= end - 1) {
            List<Integer> left = calculateOpsMemoize(operands, ops, start, newEnd, dpArr);
            List<Integer> right = calculateOpsMemoize(operands, ops, newEnd+1, end, dpArr);
            for (Integer o1: left) {
                for (Integer o2: right) {
                    if(ops.get(newEnd) == '*') {
                        int ans = o1 * o2;
                        ansArr.add(ans);
                    } else if(ops.get(newEnd) == '+') {
                        int ans = o1 + o2;
                        ansArr.add(ans);
                    } else {
                        int ans = o1 - o2;
                        ansArr.add(ans);
                    }
                }
            }

            newEnd ++;
        }

        dpArr[start][end] = ansArr;
        return ansArr;
    }

    public static List<Integer> calculate(String expression, int start, int end) {

        if(start == end) {
            int ans = expression.charAt(start) - '0' ;
            return new ArrayList<>(List.of(ans));
        }
        if(end == start+2) {
            int o1 = expression.charAt(start) - '0';
            int o2 = expression.charAt(end) - '0';
            if(expression.charAt(start+1) == '*') {
                int ans = o1 * o2;
                return new ArrayList<>(List.of(ans));
            } else if(expression.charAt(start+1) == '+') {
                int ans = o1 + o2;
                return new ArrayList<>(List.of(ans));
            } else {
                int ans = o1 - o2;
                return new ArrayList<>(List.of(ans));
            }

        }
        totalCalls++;

        List<Integer> ansArr = new ArrayList<>();
        int newEnd = start;
        while (newEnd <= end - 2) {
            List<Integer> left = calculate(expression, start, newEnd);
            List<Integer> right = calculate(expression, newEnd+2, end);
            for (Integer o1: left) {
                for (Integer o2: right) {
                    if(expression.charAt(newEnd+1) == '*') {
                        int ans = o1 * o2;
                        ansArr.add(ans);
                    } else if(expression.charAt(newEnd+1) == '+') {
                        int ans = o1 + o2;
                        ansArr.add(ans);
                    } else {
                        int ans = o1 - o2;
                        ansArr.add(ans);
                    }
                }
            }

            newEnd += 2;
        }

        return ansArr;
    }
}
