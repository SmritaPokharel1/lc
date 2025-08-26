package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC103_BTZigZacLevelOrderBFS {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        boolean flip = false;

        while(!queue.isEmpty()){

            int size = queue.size();

            List<Integer> temp = new ArrayList<>();

            while(size>0){

                TreeNode node = queue.remove();

                if(flip) temp.add(0,node.val);
                else temp.add(node.val);

                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);

                size --;
            }
            flip = !flip;

            result.add(temp);
        }

        return result;
    }
}
