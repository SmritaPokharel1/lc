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

class BalancedTree2 {
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


class BalancedTree3{

    public boolean isBalanced(TreeNode root) {

        int height = checkHeight(root);

        return height != -1;

    }

    public int checkHeight(TreeNode root){

        if(root == null ) return 0;

        int left = checkHeight(root.left);

        if(left == -1) return -1;

        int right = checkHeight(root.right);

        if(right == -1) return -1;

        int diff = Math.abs(right - left) ;

        if(diff > 1) return -1;

        return Math.max(left,right) + 1;
    }
}
