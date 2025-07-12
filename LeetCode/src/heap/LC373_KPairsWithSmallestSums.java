package heap;

import java.util.*;

/**
 * You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
 * <p>
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 * <p>
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 * <p>
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * <p>
 *
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LC373_KPairsWithSmallestSums {

    //Optimised
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);

        List<List<Integer>> result = new ArrayList<>();

        Set<List<Integer>> visited = new HashSet();

        heap.add(new int[]{nums1[0] + nums2[0], 0, 0});

        int m = nums1.length;
        int n = nums2.length;

        while (k-- > 0 && !heap.isEmpty()) {

            int[] top = heap.poll();

            int i = top[1];
            int j = top[2];

            List<Integer> one = Arrays.asList(i + 1, j);
            List<Integer> two = Arrays.asList(i, j + 1);

            if (i + 1 < m && !visited.contains(one)) {

                heap.add(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add(one);
            }

            if (j + 1 < n && !visited.contains(two)) {

                heap.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(two);
            }

            result.add(List.of(nums1[i], nums2[j]));
        }

        return result;
    }

    /**
     *
     * Unoptimised and times out after a certain point
     */
    public List<List<Integer>> kSmallestPairs_(int[] nums1, int[] nums2, int k) {

        PriorityQueue<List<Integer>> heap = new PriorityQueue<List<Integer>>((a, b) -> a.get(0) - b.get(0));

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                int first = nums1[i];
                int second = nums2[j];

                int sum = first + second;

                List<Integer> temp = new ArrayList<>();
                temp.add(0, sum);
                temp.add(1, first);
                temp.add(2, second);

                heap.add(temp);
            }

        }

        while (k > 0) {

            List<Integer> temp = heap.poll();
            temp.remove(0);

            result.add(temp);

            k--;
        }

        return result;
    }
}
