package trees;

import java.util.LinkedList;
import java.util.Queue;

public class IsSubtree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(subRoot == null) return true;

        if(root== null) return false;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            TreeNode node = queue.poll();

            if(node.val == subRoot.val && matchesTree(node, subRoot)) return true;

            if(node.left != null) queue.add(node.left);

            if(node.right != null) queue.add(node.right);
        }

        return false;

    }

    public boolean matchesTree(TreeNode root, TreeNode subRoot){

        if(root==null && subRoot == null) return true;

        if(root == null || subRoot == null) return false;

        if(root.val !=subRoot.val) return false;

        return matchesTree(root.left, subRoot.left) && matchesTree(root.right, subRoot.right);
    }
}
