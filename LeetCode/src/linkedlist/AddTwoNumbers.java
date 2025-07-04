package linkedlist;


//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        int sum =0;
        int carry =0;
        int quotient = 0;

        while(l1 !=null || l2 !=null){

            sum += carry;

            if(l1!=null){

                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){

                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            quotient = sum % 10;

            result.next = new ListNode(quotient);
            result = result.next;

            sum = 0;
        }

        if(carry >0){

            result.next = new ListNode(carry);
            result = result.next;
        }

        return dummy.next;

    }


}


