package string;

import java.util.*;

/**
 * You are provided with a list of words. Your task is to organize these words into groups where each group contains words that are simply rearrangements of the same set of characters (i.e., anagrams). The order of these groups in the final result is not important.
 *
 * Example 1:
 * Input:
 * words = ["dusty", "study", "night", "thing", "node", "done"]
 *
 * Expected Output:
 * [["node", "done"], ["night", "thing"], ["dusty", "study"]]
 *
 * Explanation:
 *
 * "dusty" and "study" share the exact same letters and hence are anagrams.
 *
 * "night" can be rearranged to form "thing".
 *
 * "node" and "done" are also anagram pairs.
 *
 * No word belongs to more than one group.
 *
 * Example 2:
 * Input:
 * words = [""]
 *
 * Expected Output:
 * [[""]]
 *
 * Example 3:
 * Input:
 * words = ["x"]
 *
 * Expected Output:
 * [["x"]]
 *
 * https://leetcode.com/problems/group-anagrams/description/
 */
public class LC49_GroupAnagramTogether {

    //Performance 1057 ms Beats 5.02%
    public static List<List<String>> groupAnagramOne(String[] strs) {

        List<Integer> visited = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            if (visited.contains(i)) continue;

            List<String> group = new ArrayList<>();
            group.add(strs[i]);

            for (int j = i + 1; j < strs.length; j++) {
                if (visited.contains(j)) continue;

                if (isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    visited.add(j);
                }
            }

            result.add(group);
        }

        return result;
    }

    public static boolean isAnagram(String s1, String s2){

        if (s1.length() != s2.length()) return false;

        int[] ascii = new int[128];

        for (char c : s1.toCharArray()) {
            ascii[c]++;
        }

        for (char c : s2.toCharArray()) {
            ascii[c]--;
            if (ascii[c] < 0) return false;
        }

        for (int count : ascii) {
            if (count != 0) return false;
        }

        return true;
    }

    //Performance 7ms
    //Beats 65.20%
    public static List<List<String>> groupAnagramsTwo(String[] strs){

        Map<String, List<String>> map = new HashMap<>();

        for(int i =0; i < strs.length; i++){

            String str = strs[i];

            char[] strarr = str.toCharArray();

            Arrays.sort(strarr);

            String key = String.valueOf(strarr);

            if(!map.containsKey(key)) map.put(key, new ArrayList<>());

            map.get(key).add(str);

        }

        return new ArrayList(map.values());
    }

    public static void main(String[] args){

        String[] targets = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> result = groupAnagramsTwo(targets);

    }
}
