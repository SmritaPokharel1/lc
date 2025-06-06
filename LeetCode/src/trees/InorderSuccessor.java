package trees;


//https://leetcode.com/problems/inorder-successor-in-bst-ii/
public class InorderSuccessor {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node inorderSuccessor(Node node) {

        while(node.right!=null){
            Node curr = node.right;

            while(curr.left!=null){
                curr = curr.left;
            }

            return curr;
        }

        Node parent = node.parent;

        while(parent!=null && parent.val <node.val){

            parent = parent.parent;
        }

        return parent;
    }
}
