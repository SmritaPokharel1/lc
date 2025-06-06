package trees;


//https://leetcode.com/problems/search-in-a-binary-search-tree/
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {

        if(root!=null){
            if(root.val == val) return root;

            if(val > root.val ) return searchBST(root.right, val);

            if(val < root.val) return searchBST(root.left,val);

        }

        return null;

    }
}
