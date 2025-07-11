package slidingwindow;


import java.util.HashMap;
import java.util.Map;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 *
 * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 *
 *
 *
 * Example 1:
 *
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * Example 2:
 *
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * Example 3:
 *
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 *
 * https://leetcode.com/problems/fruit-into-baskets/description/
 */
public class LC904_FruitsInABasket {

    public int totalFruit(int[] fruits) {

        int left = 0;
        int max = 0;

        Map<Integer, Integer> map = new HashMap();

        for(int right =0; right < fruits.length; right ++){

            int rightFruit = fruits[right];

            map.put(rightFruit, map.getOrDefault(rightFruit,0)-1);

            while(map.size()>2){

                int leftFruit = fruits[left];

                map.put(leftFruit, map.get(leftFruit) - 1);

                if(map.get(leftFruit) == 0){
                    map.remove(leftFruit);
                }
                left++;
            }

            max = Math.max(max, right-left+1);
        }

        return max;
    }
}
