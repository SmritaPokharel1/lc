package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LC3_LongestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> lastSeen = new HashMap<>();

        int start = 0;

        int n = s.length();

        int max = 0;

        for(int end = 0; end < n; end ++){

            char c = s.charAt(end);

            if(lastSeen.containsKey(c)){
                start = Math.max(start,lastSeen.get(c) +1);
            }

            lastSeen.put(c,end);

            max = Math.max(max, end - start +1) ;
        }

        return max;
    }

    public int lengthOfLongestSubstringUnoptimised(String s) {

        Map<Character, Integer> posMap = new HashMap<>();
        Map<Character, Integer> freqMap = new HashMap<>();

        int n = s.length();

        int start = 0;
        int end = start;
        int max = 0;

        while(end < n){

            char c = s.charAt(end);

            int freq = freqMap.getOrDefault(c,0) +1;

            if(freq > 1){

                max = Math.max(max, end - start);
                start = posMap.get(c) + 1;

                Set<Character> keysToRemove = new HashSet<>();

                for(char key : posMap.keySet()){

                    int index = posMap.get(key);

                    if(index < start) keysToRemove.add(key);
                }

                for(char key : keysToRemove ){

                    if(!freqMap.containsKey(key)) continue;

                    int count = freqMap.get(key) - 1;

                    if(count == 0) freqMap.remove(key);
                    else freqMap.put(key, count);
                }

                posMap.put(c,end);
            }else{

                posMap.put(c,end);
                freqMap.put(c, freq);
                end++;
            }
        }

        max = Math.max(max, end - start);

        return max;

    }
}
