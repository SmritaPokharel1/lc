package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/description/?envType=problem-list-v2&envId=heap-priority-queue
 */
public class LC451_SortCharsByFreq {

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        StringBuilder result = new StringBuilder();

        PriorityQueue<Character> heap = new PriorityQueue<Character>((a, b)-> map.get(b) - map.get(a));

        for(int i =0; i < s.length(); i++){

            char c = s.charAt(i);

            int freq = map.getOrDefault(c,0) + 1;

            map.put(c,freq);
        }

        for(Character c : map.keySet())heap.add(c);

        while(!heap.isEmpty()){

            char c = heap.poll();
            int freq = map.get(c);

            for(int i =0; i < freq; i++) result.append(c);
        }

        return result.toString();
    }
}
