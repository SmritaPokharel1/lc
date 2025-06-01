package trees;

public class BalancedTree1 {

    public boolean isBalanced(TreeNode root) {

        if(root==null) return true;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if(Math.abs(left -right) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int getHeight(TreeNode root){

        if(root==null) return 0;

        int left = getHeight(root.left) +1;

        int right = getHeight(root.right) + 1;

        return Math.max(left,right);
    }
}
