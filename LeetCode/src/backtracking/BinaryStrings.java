package backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros
public class BinaryStrings {

    public List<String> validStrings(int n) {

        List<String> result = new ArrayList();

        backtrack("", result, n);

        return result;
    }

    public void backtrack(String curr, List<String> result, int n){

        if(curr.length()==n) {

            result.add(curr);
            return;
        }

        if (curr.length() == 0 || curr.charAt(curr.length() - 1) != '0') backtrack(curr+"0",result,n);

        backtrack(curr+"1", result, n);
    }

    public static void main(String[] args){

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);

        System.out.println(list.contains(1));
    }
}
