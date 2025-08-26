package string;

/**
 * Create a function that determines the longest common prefix shared by all strings in a given list of strings.
 *
 * If the strings do not share any common prefix, the function should return an empty string "".
 *
 * Example 1:
 *
 * Input:
 * words = ["interview", "interrupt", "integrate"]
 * Output:
 * "int"
 *
 * Example 2:
 *
 * Input:
 * words = ["apple", "banana", "grape"]
 * Output:
 * ""
 * Explanation: There is no shared starting sequence among the provided strings.
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 */
public class LC14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0)  return "";

        if(strs.length == 1) return strs[0];

        String prefix = strs[0];

        for(int i =1; i < strs.length; i++){

            while(strs[i].indexOf(prefix)!=0){

                prefix = prefix.substring(0,prefix.length() -1);

                if(prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}
