package trees;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is
 * the inorder traversal of the same tree, construct and return the binary tree.
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
public class LC105_BTFromPreorderAndInOrder {

    int preorderIndex = 0;

    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length; i++) inorderMap.put(inorder[i],i);

        return buildBST(preorder, 0, preorder.length-1);

    }

    private TreeNode buildBST(int[] preorder, int left, int right){

        if(left > right) return null;

        int val = preorder[preorderIndex++];

        int index = inorderMap.get(val);

        TreeNode node = new TreeNode(val);

        node.left = buildBST(preorder, left, index-1);
        node.right = buildBST(preorder, index+1, right);

        return node;
    }
}
