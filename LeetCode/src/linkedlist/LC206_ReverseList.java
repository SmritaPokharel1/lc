package linkedlist;


/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class LC206_ReverseList {

    public ListNode reverseList(ListNode head) {

        if( head == null || head.next==null) return head;

        ListNode current = head;

        ListNode next = current.next;
        current.next = null;

        ListNode nextN = null;

        while(next!=null){

            nextN = next.next;
            next.next = current;
            current = next;
            next = nextN;
        }

        return current;

    }
}
