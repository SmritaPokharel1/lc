package slidingwindow;


import java.util.HashMap;
import java.util.Map;

//You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
//
//You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
//
//You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
//Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
//Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
//Given the integer array fruits, return the maximum number of fruits you can pick.
public class FruitsInABasket {

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
