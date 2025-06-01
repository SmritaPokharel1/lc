package trees;

public class BalancedTree2 {
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return isBalanced;
    }

    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftHeight = getHeight(root.left)+1;

        int rightHeight = getHeight(root.right)+1;

        if(Math.abs(leftHeight-rightHeight)>1){
            isBalanced = false;
        }

        if(leftHeight>rightHeight){
            return leftHeight;
        }

        return rightHeight;
    }
}
