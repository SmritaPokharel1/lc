package linkedlist;

import java.util.Stack;

/**
 * https://leetcode.com/problems/palindrome-linked-list/description/
 */
public class LC234_IsPalindrome {

    public boolean isPanlindrome(ListNode head){

        if(head==null || head.next== null) return true;

        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<Integer>();

        while(fast !=null && fast.next != null){

            stack.push(slow.val);

            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null){

            slow = slow.next;
        }

        while(slow!=null){

            if(slow.val != stack.pop()) return false;
            slow= slow.next;
        }

        return true;
    }
}
