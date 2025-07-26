package trees;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
public class LC543_DiameterOfTree {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        diameter = 0;

        getDiameter(root);

        return diameter;
    }

    private int getDiameter(TreeNode root){

        if(root==null) return -1;

        int left = getDiameter(root.left) ;

        int right = getDiameter(root.right);

        diameter = Math.max(diameter,left + right + 2);

        return Math.max(left, right) +1;

    }
}
