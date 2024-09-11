package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ListProblems {

    public static void main(String[] args) {
        // 3,0,2,6,8,1,7,9,4,2,5,5,0
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        ListNode temp2 = head2;
        temp2.next = new ListNode(3);
        temp2 = temp2.next;
        temp2.next = new ListNode(4);
//        temp = temp.next;
//        temp.next = new ListNode(1);
//        temp = temp.next;
//        temp.next = new ListNode(7);
//        temp = temp.next;
//        temp.next = new ListNode(9);
//        temp = temp.next;
//        temp.next = new ListNode(4);
//        temp = temp.next;
//        temp.next = new ListNode(2);
//        temp = temp.next;
//        temp.next = new ListNode(5);
//        temp = temp.next;
//        temp.next = new ListNode(5);
//        temp = temp.next;
//        temp.next = new ListNode(0);
//        temp = temp.next;
//        temp.next = new ListNode(0);
//        temp = temp.next;
//        temp.next = new ListNode(1);
//        temp = temp.next;
//        temp.next = new ListNode(0);
        mergeTwoLists(head, head2);
    }

    // LC21
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;

        if(p1 == null)
            return p2;

        if(p2 == null)
            return p1;

        ListNode head, tail;
        if(p1.val < p2.val) {
            head = p1;
            tail = p1;
            p1 = p1.next;
        } else {
            head = p2;
            tail = p2;
            p2 = p2.next;
        }

        while (p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                tail.next = p1;
                tail = tail.next;
                p1 = p1.next;
            } else {
                tail.next = p2;
                tail = tail.next;
                p2 = p2.next;
            }
        }

        if (p1 != null) {
            tail.next = p1;
        }

        if(p2 != null) {
            tail.next = p2;
        }

        return head;

    }

    // LC206
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while(next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }

    // LC2326
    public static int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] ans = new int[m][n];

        int r = 0, c = 0;
        int val = head != null ? head.val : -1;
        while(n > 1 && m > 1) {

            for(int l = 1; l < n; l++) {
                ans[r][c] = val;
                head = head != null ? head.next : null;
                val = head != null ? head.val : -1;
                c++;
            }

            for(int l = 1; l < m; l++) {
                ans[r][c] = val;
                head = head != null ? head.next : null;
                val = head != null ? head.val : -1;
                r++;
            }

            for(int l = 1; l < n; l++) {
                ans[r][c] = val;
                head = head != null ? head.next : null;
                val = head != null ? head.val : -1;
                c--;
            }

            for(int l = 1; l < m; l++) {
                ans[r][c] = val;
                head = head != null ? head.next : null;
                val = head != null ? head.val : -1;
                r--;
            }
            n -= 2;
            m -= 2;
            r++;
            c++;
        }

        if(n > 1 && m == 1) {
            // row is remaining
            for (int l = 1; l <= n; l++) {
                ans[r][c] = val;
                head = head != null ? head.next : null;
                val = head != null ? head.val : -1;
                c++;
            }
        }

        if(m > 1 && n == 1) {
            // col is remaining
            for (int l = 1; l <= m; l++) {
                ans[r][c] = val;
                head = head != null ? head.next : null;
                val = head != null ? head.val : -1;
                r++;
            }

        }

        if(m == 1 && n == 1) {
            ans[r][c] = val;
        }

        return ans;

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


/*
[[45,305,389,563,585,690,863,938,812,406,448,229,64,574,919,784,383,683,560,972,372,119,109,200,820,544,450,899,311,123,52,299,10],
[604,714,670,293,737,727,572,570,958,302,159,879,873,587,112,994,383,905,866,943,903,982,271,488,908,283,807,196,490,585,839,625,389],
[114,883,670,306,305,223,45,196,51,120,75,722,111,600,365,536,896,717,416,349,261,723,734,372,955,454,385,150,990,366,152,872,53],
[331,625,920,86,733,476,602,730,619,278,169,312,153,880,688,123,563,835,874,460,268,589,454,86,670,190,778,244,718,699,861,658,561],
[189,904,733,407,576,747,577,628,552,233,779,442,763,654,299,682,763,907,387,459,663,835,224,826,340,495,731,324,220,397,741,75,207],
[693,527,782,771,917,834,478,127,410,43,853,78,281,677,541,822,353,194,336,799,600,755,922,144,980,5,517,621,437,984,95,898,124],
[51,530,667,750,918,879,957,4,561,58,19,62,822,747,618,28,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,338,384,992,865,831,518],
[720,917,25,153,965,433,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,280,798,550,767,971,411],
[109,964,770,806,770,890,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,789,816,458,121,724,805],
[632,792,142,665,851,122,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,583,139,448,785,630,450],
[918,896,397,2,445,782,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,595,216,460,549,644,852],[690,765,540,48,448,38,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,651,581,381,487,175,324],[751,232,199,916,510,672,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,585,870,501,212,387,195],[944,26,76,61,15,325,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,303,661,951,308,436,585],[939,489,641,376,81,907,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,881,97,206,9,964,403],[187,229,548,284,710,373,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,134,308,427,105,825,855],[908,505,996,90,485,557,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,179,960,476,14,173,716],[286,912,227,493,571,527,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,393,614,288,695,419,622],[234,663,413,663,63,245,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,416,269,962,849,482,709],[433,774,925,80,879,707,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,912,839,576,808,116,620],[585,31,546,489,379,396,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,278,773,957,89,314,981],[371,246,517,226,938,816,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,864,680,445,195,171,528],[481,869,392,937,599,601,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,208,816,398,59,948,194],[395,474,405,899,553,815,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,873,37,71,350,678,261],[411,102,189,453,398,807,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,246,714,669,864,789,404],[218,438,119,946,553,462,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,489,150,83,551,329,263],[621,825,187,160,504,716,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,122,795,351,489,752,952],[63,364,176,558,822,159,904,522,378,122,934,71,944,408,167,165,172,727,950,910,357,988,997,538,188,866,0,446,944,832,539,830,180],[660,970,410,764,356,567,670,280,4,698,251,431,394,311,731,322,584,197,47,273,802,96,453,197,501,370,755,539,820,181,588,668,759],[193,961,454,793,817,977,757,609,736,79,68,83,505,399,351,926,130,393,609,645,331,442,44,726,231,187,325,965,15,808,578,543,523],[54,461,478,361,62,117,454,932,123,15,688,496,973,901,995,635,886,376,570,527,198,305,770,341,212,7,327,641,724,179,663,244,277],[411,505,373,869,154,43,13,915,566,772,474,746,662,412,756,30,429,438,283,136,995,350,877,941,725,452,321,658,842,17,643,36,391],[654,7,295,227,715,434,188,326,600,894,324,992,141,691,470,437,195,315,120,962,475,559,122,287,521,121,543,10,940,31,292,184,57]]

 */