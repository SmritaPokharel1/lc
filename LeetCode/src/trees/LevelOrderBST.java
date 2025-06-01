package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
public class LevelOrderBST {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();

            List<Integer> temp = new ArrayList();

            while(size>0){
                TreeNode t = q.remove();

                if(t!=null && t.left!=null)q.add(t.left);
                if(t!=null && t.right!=null)q.add(t.right);

                temp.add(t.val);
                size --;
            }

            result.add(temp);

        }

        return result;
    }
}
