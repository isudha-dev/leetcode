package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ListProblems {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
//        temp.next = new ListNode(4);
//        temp = temp.next;
//        temp.next = new ListNode(5);
//        temp = temp.next;
//        temp.next = new ListNode(6);
//        temp = temp.next;
//        temp.next = new ListNode(7);
//        temp = temp.next;
//        temp.next = new ListNode(8);
//        temp = temp.next;
//        temp.next = new ListNode(9);
//        temp = temp.next;
//        temp.next = new ListNode(10);
//        temp = temp.next;
//        temp.next = new ListNode(3);
//        temp = temp.next;
//        temp.next = new ListNode(9);
//        temp = temp.next;
//        temp.next = new ListNode(2);
//        temp = temp.next;
//        temp.next = new ListNode(0);
//        temp = temp.next;
//        temp.next = new ListNode(1);
//        temp = temp.next;
//        temp.next = new ListNode(0);
        splitListToParts(head, 5);
    }

    // LC725
    public static ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            len++;
        }

        int count = len/k;
        int remain = len%k;

        int[] listLen = new int[k];
        int toAdd = 0;
        for(int i = 0; i<listLen.length; i++) {
            if(remain > 0) {
                toAdd = 1;
                remain--;
            } else {
                toAdd = 0;
            }
            listLen[i] = count+toAdd;
        }

        ListNode[] ans = new ListNode[k];
        temp = head;

        int idx = 0;
        while(temp != null) {
            ListNode newHead = temp;
            ans[idx]= newHead;
            int currLen = listLen[idx];
            while(newHead != null && currLen > 1) {
                newHead = newHead.next;
                currLen--;
            }
            temp = newHead.next;
            newHead.next = null;
            idx++;
        }

        return ans;

    }

    // LC3217
    public static ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(i -> set.add(i));

        while (set.contains(head.val)){
            head = head.next;
        }

        ListNode prev = head;
        ListNode curr = prev.next;


        while(curr != null) {
            if(set.contains(curr.val)) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;

    }

    // 2807
    public static ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
            ListNode newNode = new ListNode(gcd(prev.val, curr.val));
            newNode.next = curr;
            prev.next = newNode;
        }

        return head;

    }

    static int gcd(int a, int b) {
        if(a == 0)
            return b;

        return gcd(b%a, a);
    }


    // 2181
    public static ListNode mergeNodes(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null && curr.next != null) {
            int sum = 0;
            while (curr != null && curr.val != 0) {
                sum += curr.val;
                curr = curr.next;
            }
            prev.val = sum;
            prev.next = curr;
            if(prev.next.next == null) {
                prev.next = null;
            }
            prev = curr;
            curr = prev.next;
        }

        return head;
    }

     static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
