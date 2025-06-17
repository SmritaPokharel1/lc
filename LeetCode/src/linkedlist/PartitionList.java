package linkedlist;

//https://leetcode.com/problems/partition-list/description/
public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;

        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        ListNode current = head;

        while(current != null){

            if(current.val < x){

                before = current;
                before = before.next ;
            }else{

                after = current;
                after = after.next;
            }

            ListNode next = current.next;
            current.next = null;
            current = next;
        }

        before = afterHead.next;

        return beforeHead.next;
    }
}
