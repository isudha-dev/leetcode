package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC653 {

    class TreeNode {
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

    public static void main(String[] args) {
        findTarget(null, 10);
    }
    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> levelOrderArr = new ArrayList<>();
        levelOrder(root, levelOrderArr);

        int p1 = 0; int p2 = levelOrderArr.size()-1;

        while (p1<p2) {
            int currSum = levelOrderArr.get(p1) + levelOrderArr.get(p2);
            if(currSum == k) {
                return true;
            } else if (currSum < k){
                p1++;
            } else {
                p2--;
            }
        }

        return false;
    }

    public static void levelOrder(TreeNode root, List<Integer> arr) {
        if(root == null)
            return;

        levelOrder(root.left, arr);
        arr.add(root.val);
        levelOrder(root.right, arr);
    }
}
