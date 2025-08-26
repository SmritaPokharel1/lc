package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 *
 * Output: [1,3,2]
 *
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */
public class LC94_InorderTraversalOfBST {


    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();

        inorderRec(root, list);

        return list;
    }

    public void inorderRec(TreeNode root, List<Integer> result) {

        if (root != null) {

            inorderRec(root.left, result);

            result.add(root.val);

            inorderRec(root.right, result);
        }
    }

    public List<Integer> inorderIt(TreeNode root){

        List<Integer> result = new ArrayList();

        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode current = root;

        while(!stack.isEmpty() || current != null){

            while(current!=null){

                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }
}
