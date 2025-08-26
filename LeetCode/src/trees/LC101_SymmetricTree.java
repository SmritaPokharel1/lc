package trees;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * https://leetcode.com/problems/symmetric-tree/description/
 */
public class LC101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        return isMirror(root.left, root.right);

    }

    private boolean isMirror(TreeNode left, TreeNode right){

        if(left==null && right== null) return true;

        if(left==null || right==null) return false;

        if(left.val!=right.val) return false;

        return isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }
}
