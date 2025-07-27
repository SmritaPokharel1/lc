package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
public class LC230_KthSmallestElement {

    public int kthSmallest(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();

        inorder(root, list);

        return list.get(k-1);
    }

    public void inorder(TreeNode root, List<Integer> result){

        if(root!=null){

            inorder(root.left,result);
            result.add(root.val);
            inorder(root.right,result);
        }
    }
}
