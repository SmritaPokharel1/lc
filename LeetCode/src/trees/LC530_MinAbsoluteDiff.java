package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given the root of a Binary Search Tree (BST),
 * return the minimum absolute difference between the values of any two different nodes in the tree.
 * <p>
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 */
public class LC530_MinAbsoluteDiff {

    List<Integer> inorder = new ArrayList<>();

    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        inOrderTraversal(root);

        for (int i = 1; i < inorder.size(); i++) {

            int num1 = inorder.get(i - 1);
            int num2 = inorder.get(i);

            int diff = Math.abs(num2 - num1);
            min = Math.min(min, diff);
        }

        return min;
    }

    public void inOrderTraversal(TreeNode root) {

        if (root != null) {

            inOrderTraversal(root.left);
            inorder.add(root.val);
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {

        String test = "1,2,3,";

        String[] res = test.split(",");

        System.out.println(res.length);

        Arrays.stream(res).forEach(a -> System.out.println(a));
    }
}
