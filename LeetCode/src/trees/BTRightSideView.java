package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-right-side-view/
public class BTRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        return bfs(root);
    }

    public List<Integer> bfs(TreeNode root){

        List<Integer> result = new ArrayList<>();

        if(root==null) return result;

        Queue<TreeNode> queue = new LinkedList();

        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            while(size >0){

                TreeNode node = queue.remove();
                if(size==1){
                    result.add(node.val);
                }
                size --;

                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
        }

        return result;
    }
}
