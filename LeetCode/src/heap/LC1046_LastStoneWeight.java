package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 *
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 *
 * Return the weight of the last remaining stone. If there are no stones left, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: stones = [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
 * Example 2:
 *
 * Input: stones = [1]
 * Output: 1
 *
 * https://leetcode.com/problems/last-stone-weight/description/
 */

public class LC1046_LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        if(stones.length==0) return 0;

        if(stones.length==1) return stones[0];

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int stone:stones) heap.add(stone);

        while(heap.size() > 1){

            int y = heap.poll();
            int x = heap.poll();

            if(x!=y){
                heap.add(y-x);
            }
        }

        return heap.isEmpty()? 0: heap.poll();
    }
}
