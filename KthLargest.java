package leetcode;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> pq;
    int size;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        size = k;
        for(int i: nums){
            add(i);
        }
    }

    public int add(int val) {
        if(pq.size() < size){
            pq.add(val);
        } else {
            int top = pq.peek();
            if(top < val){
                pq.poll();
                pq.add(val);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargest kl = new KthLargest(3, new int[] {4, 5, 8, 2});
        System.out.println(kl.add(3));
        System.out.println(kl.add(5));
        System.out.println(kl.add(10));
        System.out.println(kl.add(9));
        System.out.println(kl.add(4));
    }
}
