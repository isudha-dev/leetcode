package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC3043 {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[10];
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            isEnd = false;
        }
    }

    TrieNode head = new TrieNode();

    public static void main(String[] args) {
        LC3043 lc = new LC3043();
        System.out.println(lc.longestCommonPrefix(new int[] {1,26}, new int[] {22,2}));


    }
    public void insert(String s) {
        TrieNode node = head;
        int idx = 0;
        while(idx < s.length()) {
            int i = s.charAt(idx)-'0';
            if(node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
            idx++;
        }
        node.isEnd = true;
    }

    public int findCommonPrefixLen(String s) {
        TrieNode node = head;
        int idx = 0, count = 0;
        while(idx < s.length() && node.children[s.charAt(idx) - '0'] != null) {
            count++;
            node = node.children[s.charAt(idx) - '0'];
            idx++;
        }
        return count;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        for (int i : arr1) {
            insert(i+"");
        }

        int max = Integer.MIN_VALUE;
        for (int i : arr2) {
            int currLen = findCommonPrefixLen(i+"");
            max = Math.max(max, currLen);
        }

        return max;
    }


}