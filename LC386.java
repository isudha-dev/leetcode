package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


// TODO
public class LC386 {
    // 1,10,11,12,13,2,3,4,5,6,7,8,9

    public static void main(String[] args) {
        int[] arr = new int[200000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;

        }
        Stream<Integer> arrI = Arrays.stream(arr).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return String.valueOf(o1).compareTo(String.valueOf(o2));
            }
        });

        arrI.forEach(System.out::println);
//        lexicalOrder(50);

    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i<=n; i++) {
            ans.add(i);
        }

        ans.sort(Comparator.comparing(String::valueOf));

        // 101 11
        ans.forEach(System.out::println);
        return ans;

    }
}
