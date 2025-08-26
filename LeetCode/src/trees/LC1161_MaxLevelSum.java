package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LC1161_MaxLevelSum {

    public int maxLevelSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        int max  = Integer.MIN_VALUE;
        int minLevel = 0;
        int level = 0;

        while(!queue.isEmpty()){

            int size = queue.size();

            int sum = 0;

            while(size > 0 ){

                TreeNode node = queue.remove();

                sum += node.val;

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);

                size --;
            }

            level ++;

            if(max < sum){
                max = sum;
                minLevel = level;
            }
        }

        return minLevel;
    }
}
