package trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/create-binary-tree-from-descriptions/
public class CreateBTFromDescription {

    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> treeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for(int[] desc:descriptions){

            int parent = desc[0];
            int child = desc[1];
            boolean isLeft = desc[2]==1;

            if(!treeMap.containsKey(parent)){

                treeMap.put(parent, new TreeNode(parent));
            }

            if(!treeMap.containsKey(child)){

                treeMap.put(child, new TreeNode(child));
            }

            if(isLeft){

                treeMap.get(parent).left = treeMap.get(child);
            }else{

                treeMap.get(parent).right = treeMap.get(child);
            }

            children.add(child);
        }

        for(TreeNode node: treeMap.values()){

            if(!children.contains(node.val)) return node;
        }

        return null;
    }
}

