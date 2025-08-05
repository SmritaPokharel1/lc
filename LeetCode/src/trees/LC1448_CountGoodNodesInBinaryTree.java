package trees;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 *
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
 */
public class LC1448_CountGoodNodesInBinaryTree {

    private int count = 0;

    private List<Integer> list = new ArrayList<>();

    public int goodNodes(TreeNode root) {

        dfs(root);

        return count;
    }

    private void dfs(TreeNode root){

        if(root!=null){

            boolean isGood = true;

            for(int i = 0; i < list.size(); i++){

                if(list.get(i) > root.val){

                    isGood = false;
                    break;
                }
            }

            if(isGood) count++;

            list.add(root.val);

            dfs(root.left);
            dfs(root.right);

            list.remove(list.size() - 1);
        }
    }
}
