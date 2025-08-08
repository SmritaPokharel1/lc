package linkedlist;

import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted linked list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 */
public class LC23_MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();

        ListNode head = new ListNode();

        ListNode result = head;

        for(int i = 0; i < lists.length; i++){

            ListNode temp = lists[i];

            while(temp != null){

                minheap.add(temp.val);
                temp = temp.next;
            }
        }

        while(!minheap.isEmpty()){

            result.next = new ListNode(minheap.poll());
            result = result.next;
        }

        return head.next;
    }
}
