package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
public class LC102_LevelOrderBST {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            List<Integer> list = new ArrayList<>();

            while(size>0){

                TreeNode node = queue.remove();

                if(node!=null){

                    list.add(node.val);

                    if(node.left!=null) queue.add(node.left);

                    if(node.right!=null) queue.add(node.right);
                }

                size --;
            }
            if(!list.isEmpty()) result.add(list);
        }

        return result;
    }
}
