package linkedlist;

//https://leetcode.com/problems/delete-node-in-a-linked-list/
public class DeleteGivenNode {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;

        ListNode next = node.next;

        node.next = next.next;

        next.next = null;

    }
}
