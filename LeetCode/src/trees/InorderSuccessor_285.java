package trees;

//https://leetcode.com/problems/inorder-successor-in-bst/description/
public class InorderSuccessor_285 {

    TreeNode successor = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        while(root!=null){

            if(p.val < root.val){

                successor = root;
                root = root.left;
            }else{

                root = root.right;
            }
        }

        return successor;
    }


}


