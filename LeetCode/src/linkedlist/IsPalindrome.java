package linkedlist;

import java.util.Stack;

public class IsPalindrome {

    public boolean isPanlindrome(ListNode head){

        if(head==null || head.next==null) return true;

        ListNode slow = head;
        ListNode fast = head;

        Stack<Integer> stack = new Stack<Integer>();

        while(fast!=null && fast.next!=null){

            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while(slow!=null){

            stack.push(slow.val);
            slow = slow.next;
        }

        while(!stack.isEmpty()){

            if(head.val!=stack.pop()) return false;

            head = head.next;
        }

        return true;
    }
}
