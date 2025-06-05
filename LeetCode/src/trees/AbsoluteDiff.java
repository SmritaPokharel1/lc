package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//https://leetcode.com/problems/minimum-absolute-difference-in-bst/
public class AbsoluteDiff {

    List<Integer> minNums = new ArrayList<>();

    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        inOrderTraversal(root);

        for(int i =0;i<minNums.size()-1; i++){

            int diff = minNums.get(i+1) - minNums.get(i);

            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    public void inOrderTraversal(TreeNode root){

        if(root!=null){

            inOrderTraversal(root.left);

            minNums.add(root.val);

            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args){

        String test = "1,2,3,";

        String[] res = test.split(",");

        System.out.println(res.length);

        Arrays.stream(res).forEach(a ->System.out.println(a));
    }
}
