package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is
 * the postorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 */
public class LC106_BTFromPostorderAndInorder {

    int postorderIndex = 0;

    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postorderIndex = postorder.length - 1;

        for(int i =0; i < inorder.length; i++) inorderMap.put(inorder[i],i);

        return buildTree(postorder, 0, postorder.length-1);
    }


    public TreeNode buildTree(int[] postorder, int left, int right){

        if(left > right) return null;

        int val = postorder[postorderIndex--];

        int index = inorderMap.get(val);

        TreeNode node = new TreeNode(val);

        node.right = buildTree(postorder, index+1, right);
        node.left = buildTree(postorder, left, index - 1);

        return node;
    }
}
