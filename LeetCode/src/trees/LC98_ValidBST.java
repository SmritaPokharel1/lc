package trees;

/**
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys strictly less than the node's key.
 * The right subtree of a node contains only nodes with keys strictly greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 */
public class LC98_ValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long min, long max){

        if(root == null) return true;

        if(root.val <= min || root.val >=max) return false;

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
