package linkedlist;

//https://medium.com/@smrita/basic-operations-in-a-linked-list-5b71e01a4a37

//Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//
//Return true if there is a cycle in the linked list. Otherwise, return false

//https://leetcode.com/problems/linked-list-cycle/
public class DetectCycle {

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){

            fast = fast.next.next;

            slow = slow.next;

            if(fast == slow) return true;
        }

        return false;
    }

//    Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
//
//    Do not modify the linked list.

//    https://leetcode.com/problems/linked-list-cycle-ii/description/
    public ListNode getStartOfCycle(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){

            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){

                fast = head;

                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}

