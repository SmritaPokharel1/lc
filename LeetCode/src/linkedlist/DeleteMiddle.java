package linkedlist;

public class DeleteMiddle {

    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        ListNode target = null;


        while (fast != null && fast.next != null) {

            target = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow.next == null) {
            target.next = null;
        } else {
            target.next = slow.next;
            slow.next = null;
        }

        return head;
    }
}
