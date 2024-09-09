package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeProblems {
    static TreeNode myNode;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);

        TreeNode temp = root.left;
        temp.right = new TreeNode(2);

        temp = temp.right;
        temp.left = new TreeNode(1);

        temp = root.right;
        temp.left = new TreeNode(2);

        temp = temp.left;
        temp.left = new TreeNode(6);
        temp.right = new TreeNode(8);

        temp = temp.right;
        temp.left = new TreeNode(1);
        temp.right = new TreeNode(3);

        ListNode listNode = new ListNode(4);
        ListNode tempList = listNode;
        tempList.next = new ListNode(2);
        tempList = tempList.next;
        tempList.next = new ListNode(8);

        System.out.println(isSubPath(listNode, root));

    }

    // LC1367
    public static boolean isSubPath(ListNode head, TreeNode root) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int listLen = list.size();
        boolean ans = false;
        boolean[] visited = new boolean[listLen];

        subPathHelper(root, 0, list, visited);

        return ans;
    }

    static void subPathHelper(TreeNode root, int idx, List<Integer> list, boolean[] visited) {
        if (root == null)
            return;

        if(root.val == list.get(idx) && (idx == 0 || visited[idx-1])) {
            visited[idx] = true;
            idx++;
        } else {
            idx = 0;
            visited = new boolean[list.size()] ;
        }

        subPathHelper(root.left, idx, list, visited);
        subPathHelper(root.right, idx, list, visited);

    }

    // LC1038
    public static TreeNode bstToGst(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        inorder(root, traversal);

        for(int i = traversal.size() - 2; i >= 0; i--) {
            traversal.set(i, traversal.get(i+1)+traversal.get(i));
        }

        inorderSet(root, traversal);
        return root;
    }

    public static void inorderSet(TreeNode root, List<Integer> traversal) {
        if(root == null)
            return;

        inorderSet(root.left, traversal);
        root.val = traversal.get(0);
        traversal.remove(0);
        inorderSet(root.right, traversal);
    }

    public static void inorder(TreeNode root, List<Integer> traversal) {
        if(root == null)
            return;

        inorder(root.left, traversal);
        traversal.add(root.val);
        inorder(root.right, traversal);
    }

    // LC98
    public static boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValid(TreeNode root, int left, int right) {
        if(!(root.val >= left) || !(root.val <= right))
            return false;

        boolean leftAns = false;
        if(root.left == null)
            leftAns = true;
        else if (root.val != Integer.MIN_VALUE)
            leftAns =  isValid(root.left, left, root.val-1);

        boolean rightAns = false;
        if(root.right == null)
            rightAns = true;
        else if (root.val != Integer.MAX_VALUE)
            rightAns = isValid(root.right, root.val+1, right);

        return leftAns && rightAns;
    }

    // LC101
    public static boolean isSymmetric(TreeNode root) {
        List<Integer> leftInOrder = new ArrayList<>();
        List<Character> leftInOrderChar = new ArrayList<>();
        inorder(root.left, leftInOrder, leftInOrderChar, 'L');

        List<Integer> rightInOrder = new ArrayList<>();
        List<Character> rightInOrderChar = new ArrayList<>();
        inorder(root.right, rightInOrder, rightInOrderChar, 'R');

        if(leftInOrder.size() != rightInOrder.size())
            return false;
        else {
            int p1 = 0;
            int p2 = leftInOrder.size() - 1;

            while(p1 < leftInOrder.size()) {
                if((leftInOrder.get(p1) != rightInOrder.get(p2)) || (leftInOrderChar.get(p1) == rightInOrderChar.get(p2)))
                    return false;

                p1++;
                p2--;
            }
        }

        return true;


    }

    public static void inorder(TreeNode root, List<Integer> ans, List<Character> ansChar, char c) {
        if(root == null)
            return;

        inorder(root.left, ans, ansChar, 'L');
        ans.add(root.val);
        ansChar.add(c);
        inorder(root.right, ans, ansChar, 'R');
    }

    public static boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if(left == null || right == null)
            return false;

        if(left.val != right.val)
            return false;

        return isSame(left.left, right.right) && isSame(left.right, right.left);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
