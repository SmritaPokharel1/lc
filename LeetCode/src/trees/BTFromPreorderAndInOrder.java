package trees;

import java.util.HashMap;
import java.util.Map;

public class BTFromPreorderAndInOrder {

    int preOrderIndex = 0;

    Map<Integer,Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        inorderIndexMap = new HashMap<>();

        for(int i =0; i<inorder.length; i++){

            inorderIndexMap.put(inorder[i],i);
        }

        return createBT(preorder, 0, preorder.length - 1);
    }

    TreeNode createBT(int[] preorder, int left, int right){

        if(left > right) return null;

        int rootVal = preorder[preOrderIndex++];

        TreeNode node = new TreeNode(rootVal);

        node.left = createBT(preorder, left, inorderIndexMap.get(rootVal)-1);

        node.right = createBT(preorder, inorderIndexMap.get(rootVal)+1, right);

        return node;
    }
}
