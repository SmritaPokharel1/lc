package trees;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class BSTFromSortedArray {

    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums,0,nums.length-1);
    }

    public TreeNode createBST(int[] nums, int left, int right){

        if(left > right) return null;

        int mid = left + (right - left)/2;

        TreeNode tree = new TreeNode(nums[mid]);

        tree.left = createBST(nums, left, mid-1);
        tree.right = createBST(nums, mid+1, right);

        return tree;
    }
}
