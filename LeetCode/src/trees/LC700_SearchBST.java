package trees;


/**
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 * If such a node does not exist, return null.
 *
 * https://leetcode.com/problems/search-in-a-binary-search-tree/description/
 */
public class LC700_SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {

        if(root==null) return root;

        if(root.val == val) return root;

        if(root.val > val) return searchBST(root.left, val);

        else return searchBST(root.right,val);
    }
}
