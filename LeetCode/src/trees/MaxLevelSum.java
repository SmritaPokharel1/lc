package trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {

    public int maxLevelSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList();

        if(root==null) return 0;

        queue.add(root);

        int maxSum = Integer.MIN_VALUE;

        int minLevel = Integer.MAX_VALUE;

        int level = 1;

        while(!queue.isEmpty()){

            int size = queue.size();

            int sum = 0;

            while(size >0){

                TreeNode node = queue.remove();
                sum += node.val;

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);

                size --;
            }

            if(maxSum < sum){

                maxSum = sum;
                minLevel = level;
            }

            level++;
        }

        return minLevel;
    }
}
