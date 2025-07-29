package string;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/first-unique-character-in-a-string/submissions/1652101467/
public class LC387_FirstUniqueCharacter {


    public int firstUniqCharWithAsciiArray(String s){

        int[] ascii = new int[128];

        for(char c : s.toCharArray()){

            ascii[c] ++;
        }

        for(int i =0; i< s.length(); i++){

            char c = s.charAt(i);

            if(ascii[c] == 1) return i;
        }

        return -1;
    }
    public int firstUniqCharWithMaps(String s) {

        Map<Character, Integer> freqMap = new HashMap();

        Map<Character,Integer> uniChars = new HashMap();

        List<Character> uniCharsList = new ArrayList();

        int result = 0;

        for(int i =0; i< s.length(); i++){

            Character c = s.charAt(i);

            int freq = freqMap.getOrDefault(c,0) +1;

            freqMap.put(c, freq);

            if(freq>1){

                uniChars.remove(c);
                uniCharsList.remove(c);
            }
            else{

                uniChars.put(c,i);
                uniCharsList.add(c);
            }
        }
        return uniCharsList.size()>0? uniChars.get(uniCharsList.get(0)): -1;
    }
}
