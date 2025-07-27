package trees;


/**
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * https://leetcode.com/problems/invert-binary-tree/description/
 */
public class LC226_InvertBT {

    public TreeNode invertTree(TreeNode root){

        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }
}
