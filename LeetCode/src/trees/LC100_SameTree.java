package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * https://leetcode.com/problems/same-tree/description/
 */
public class LC100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        return isSameI(p,q);
    }

    public boolean isSameR(TreeNode p, TreeNode q){

        if(p==null && q==null) return true;

        if(p==null || q==null) return false;

        if(p.val!=q.val) return false;

        return isSameR(p.left,q.left) && isSameR(p.right,q.right);
    }

    public boolean isSameI(TreeNode p, TreeNode q){

        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();

        if(p==null && q==null) return true;

        if(p==null || q ==null) return false;

        q1.add(p);
        q2.add(q);

        while(!q1.isEmpty() || !q2.isEmpty()){

            TreeNode first = q1.remove();
            TreeNode second = q2.remove();

            if(first==null && second != null) return false;

            if(first !=null && second == null) return false;

            if(first != null && second != null && first.val != second.val) return false;

            if(first != null){

                q1.add(first.left);
                q1.add(first.right);
            }

            if(second !=null){

                q2.add(second.left);
                q2.add(second.right);
            }

        }

        return true;
    }
}
