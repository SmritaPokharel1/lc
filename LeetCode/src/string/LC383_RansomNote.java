package string;

//https://leetcode.com/problems/ransom-note/description/
public class LC383_RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] ascii = new int[128];

        for(char c : magazine.toCharArray()){

            ascii[c]++;
        }

        for(char c : ransomNote.toCharArray()){

            ascii[c] --;

            if(ascii[c]<0) return false;
        }

        return true;

    }
}
