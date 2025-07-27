package linkedlist;


/**
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 */
public class LC2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;

        int sum = 0;

        ListNode result = new ListNode(0);

        ListNode head = result;

        while(l1 != null || l2 != null){

            if(l1!=null){

                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){

                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;

            result.next = new ListNode(sum %10);
            result = result.next;
            carry = sum /10;

            sum = 0;
        }

        if(carry > 0){

            result.next = new ListNode(carry);
            result = result.next;
        }

        return head.next;
    }


}


