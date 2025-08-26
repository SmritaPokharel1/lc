package string;

/**
 * You are given a string text. Ignore cases and remove everything that's not a letter or digit. After cleaning, check if the string reads the same backwards as forwards.
 *
 * Return true if it does, otherwise return false.
 *
 * Example 1:
 * Input: text = "Step on no pets"
 * Output: true
 * Explanation: After cleaning, it becomes "steponnopets", which is identical when reversed.
 *
 * Example 2:
 * Input: text = "OpenAI 2024"
 * Output: false
 * Explanation: "openai2024" is not a palindrome.
 *
 * Example 3:
 * Input: text = " "
 * Output: true
 * Explanation: Once spaces are removed, the string is empty, which is considered a palindrome.
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 */
public class LC125_Palindrome {

    public String sanitizeString(String s){
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]","");


        return s;
    }

    public boolean isPalindrome(String s){

        s = sanitizeString(s);

        int left = 0;

        int right = s.length() - 1;

        while(left < right){

            if(s.charAt(left)!=s.charAt(right)) return false;

            left ++;
            right --;
        }

        return true;
    }

}
