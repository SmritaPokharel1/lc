package linkedlist;

public class SumTwoLists {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);

        ListNode current = head;

        int carry = 0;

        while(l1 !=null || l2 !=null){

            int sum =  carry;

            if(l1!=null){

                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){

                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum /10;
            sum = sum % 10;

            current.next = new ListNode(sum);
            current = current.next;
        }

        if(carry >0){

            current.next = new ListNode(carry);
            current = current.next;
        }

        return head.next;
    }
}
