package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
public class LevelOrderBST {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList();

        if(root==null) return result;

        Queue<TreeNode> queue = new LinkedList();

        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            List<Integer> temp = new ArrayList();

            while( size > 0 ){

                TreeNode node = queue.remove();

                temp.add(node.val);

                if(node.left !=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);

                size --;
            }

            result.add(temp);
        }

        return result;
    }
}
