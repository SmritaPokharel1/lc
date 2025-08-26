package string;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string s consisting of lowercase English letters.
 *
 * Your task is to find the maximum difference diff = freq(a1) - freq(a2) between the frequency of characters a1 and a2 in the string such that:
 *
 * a1 has an odd frequency in the string.
 * a2 has an even frequency in the string.
 * Return this maximum difference.
 *
 * Example 1:
 *
 * Input: s = "aaaaabbc"
 *
 * Output: 3
 *
 * Explanation:
 *
 * The character 'a' has an odd frequency of 5, and 'b' has an even frequency of 2.
 * The maximum difference is 5 - 2 = 3.
 * Example 2:
 *
 * Input: s = "abcabcab"
 *
 * Output: 1
 *
 * Explanation:
 *
 * The character 'a' has an odd frequency of 3, and 'c' has an even frequency of 2.
 * The maximum difference is 3 - 2 = 1.
 *
 * https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/
 */
public class LC3422_MaxDiffBetweenEvenOddFreq {

    //Using ascii character array to track frequency gives better performance
    // Runtime = 1ms
    public int maxDifferenceAt1ms(String s) {

        int[] counter = new int[128];

        int minEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;

        for(int i = 0; i < s.length() ; i++) counter[s.charAt(i)]++;

        for(int freq : counter){

            if(freq ==0) continue;

            if(freq%2 == 0){

                minEven = Math.min(minEven, freq);
            }else{

                maxOdd = Math.max(maxOdd, freq);
            }
        }

        return maxOdd - minEven;
    }

    //Using hashmap : Runtime : 3ms
    public int maxDifferenceAt3ms(String s) {

        Map<Character, Integer> freqMap = new HashMap();

        int minEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;

        for(int i = 0; i < s.length() ; i++){

            char c = s.charAt(i);

            int freq = freqMap.getOrDefault(c,0) +1;
            freqMap.put(c,freq);
        }

        for(char c : freqMap.keySet()){

            int freq = freqMap.get(c);

            if(freq%2 == 0){

                minEven = Math.min(minEven, freq);
            }else{

                maxOdd = Math.max(maxOdd, freq);
            }
        }

        return maxOdd - minEven;
    }
}
