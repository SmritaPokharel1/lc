package linkedlist;



public class ReverseList {

    public ListNode reverseList(ListNode head) {

        if(head==null || head.next == null) return head;

        ListNode node = head;

        ListNode next = node.next;

        ListNode nextN = null;

        node.next = null;

        while(next !=null){

            nextN = next.next;

            next.next = node;

            node = next;

            next = nextN;
        }

        return node;
    }
}
