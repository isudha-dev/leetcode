package leetcode;

import java.util.HashMap;

public class LC2416 {

    public static void main(String[] args) {
        LC2416 lc = new LC2416();
        lc.sumPrefixScores2(new String[]{"abc", "ab", "bc", "b"});
    }

    class TrieNode {
        TrieNode[] children;
        int count;

        public TrieNode() {
            children = new TrieNode[26];
            for (int i = 0; i < 25; i++) {
                children[i] = null;
            }
            count = 0;
        }
    }

    TrieNode root = new TrieNode();

    public void insert(String s) {
        TrieNode temp = root;
        for(char c: s.toCharArray()) {
            int i = c-'a';
            if(temp.children[i] == null) {
                temp.children[i] = new TrieNode();
            }
            temp.children[i].count = temp.children[i].count+1;
            temp = temp.children[i];
        }
    }

    public int sumPrefixScoreTrie(String s) {
        TrieNode temp = root;
        int sum = 0;
        for(char c: s.toCharArray()) {
            int i = c-'a';
            sum += temp.children[i].count;
            temp = temp.children[i];
        }
        return sum;
    }

    public int[] sumPrefixScores2(String[] words) {
        for (String s: words) {
            insert(s);
        }

        int[] ans = new int[words.length];

        if(words.length == 1)
            return new int[] {words[0].length()};

        int indx = 0;
        for (String s: words) {
            ans[indx++] = sumPrefixScoreTrie(s);
        }

        return ans;
    }

    public static int[] sumPrefixScores1(String[] words) {

        if(words.length == 1) {
            return new int[] {words[0].length()};
        }

        HashMap<String, Integer> map = new HashMap<>();

        for(String s: words) {
            for(int i = 0; i < s.length(); i++) {
                String temp = s.substring(0, i+1);
                map.put(temp, map.getOrDefault(temp, 0)+1);
            }
        }

        int idx = 0;
        int[] ans = new int[words.length];
        for(String s: words) {
            int sum = 0;
            for(int i = 0; i < s.length(); i++) {
                String temp = s.substring(0, i+1);
                sum += map.get(temp);
            }
            ans[idx++] = sum;
        }

        return ans;
    }
}
