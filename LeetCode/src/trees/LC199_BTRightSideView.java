package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,null,5,null,4]
 *
 * Output: [1,3,4]
 *
 * Example 2:
 *
 * Input: root = [1,2,3,4,null,null,null,5]
 *
 * Output: [1,3,4,5]
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 */
public class LC199_BTRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> rsv = new ArrayList<>();

        if(root==null) return rsv;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            while(size > 0){

                TreeNode node = queue.remove();

                if(node.left != null) queue.add(node.left);

                if(node.right != null) queue.add(node.right);

                if(size==1) rsv.add(node.val);

                size --;
            }

        }

        return rsv;
    }
}
