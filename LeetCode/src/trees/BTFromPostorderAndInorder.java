package trees;

import java.util.HashMap;
import java.util.Map;

public class BTFromPostorderAndInorder {

    int index = 0;

    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        index = postorder.length - 1;

        for(int i =0; i < inorder.length; i++){

            inorderMap.put(inorder[i],i);
        }

        return buildTree(postorder, 0, postorder.length -1);
    }

    public TreeNode buildTree(int[] postorder, int left, int right){

        if(left > right) return null;

        int nodeVal = postorder[index--];

        int rootIndex = inorderMap.get(nodeVal);

        TreeNode root = new TreeNode(nodeVal);

        root.right = buildTree(postorder, rootIndex + 1, right);
        root.left = buildTree(postorder, left, rootIndex-1);

        return root;
    }
}
