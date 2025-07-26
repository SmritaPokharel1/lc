package linkedlist;

import java.util.Stack;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * https://leetcode.com/problems/reorder-list/description/
 */
public class LC143_ReorderList {

    public void reorderList(ListNode head) {

        Stack<ListNode> stack = new Stack<ListNode>();

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = null;

        while(temp!=null){

            stack.push(temp);
            temp = temp.next;
        }

        ListNode current = head;

        while(!stack.isEmpty()){

            ListNode node = stack.pop();
            node.next = current.next;
            current.next = node;
            current = node.next;
        }

    }
}
