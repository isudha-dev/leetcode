package leetcode;

public class LC208 {
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for(Character c: word.toCharArray()) {
            if(temp.children[c-'a'] == null) {
                temp.children[c-'a'] = new TrieNode();
            }
            temp = temp.children[c-'a'];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for(Character c: word.toCharArray()) {
            if(temp.children[c-'a'] == null) {
                return false;
            }
            temp = temp.children[c-'a'];
        }
        return temp.isEnd;

    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(Character c: prefix.toCharArray()) {
            if(temp.children[c-'a'] == null) {
                return false;
            }
            temp = temp.children[c-'a'];
        }

        return !temp.isEnd;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}
