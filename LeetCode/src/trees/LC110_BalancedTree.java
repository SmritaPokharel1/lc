package trees;


/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * https://leetcode.com/problems/balanced-binary-tree/description/
 */
public class LC110_BalancedTree {

    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {

        getHeight(root);

        return isBalanced;

    }

    public int getHeight(TreeNode root){

        if(root == null) return 0;

        int left = getHeight(root.left) + 1;

        int right = getHeight(root.right) + 1;

        int diff = Math.abs(right - left);

        if(diff > 1) isBalanced = false;

        return left > right ? left : right;
    }
}
