package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class LC729 {

    public static void main(String[] args) {
        LC729 lc = new LC729();
        /*

        [[],[20,29],[13,22],[44,50],[1,7],[2,10],[14,20],[19,25],[36,42],[45,50],[47,50],[39,45],[44,50],[16,25],[45,50],[45,50],[12,20],[21,29],[11,20],[12,17],[34,40],[10,18],[38,44],[23,32],[38,44],[15,20],[27,33],[34,42],[44,50],[35,40],[24,31]]
         */
        System.out.println(lc.book(47,50));
        System.out.println(lc.book(33,41));
        System.out.println(lc.book(39,45));
        System.out.println(lc.book(33,42));
        System.out.println(lc.book(25,32));
        System.out.println(lc.book(26,35));
        System.out.println(lc.book(19,25));
        System.out.println(lc.book(3,8));
        System.out.println(lc.book(8,13));
        System.out.println(lc.book(18,27));
    }

    TreeMap<Integer, Integer> calendar;

    public LC729() {
        calendar  = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
