package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversalOfBST {


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
