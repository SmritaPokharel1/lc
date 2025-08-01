package trees;

//https://leetcode.com/problems/unique-binary-search-trees
//https://medium.com/@smrita/catalan-number-42b33ae2c2ca
public class LC96_UniqueBST {

    public int numTrees(int n) {

        return catalan(n);
    }

    public int catalan(int n){

        long C = 1;

        for(int i =0; i < n; ++i){

           C = (C * 2 * (2 * i + 1)) / (i + 2);
        }

        return (int) C;
    }

    public int catalanRecursive(int n){

        if(n <= 1) return 1;

        int result = 0;

        for(int i =0; i < n; i++){

            result += catalanRecursive(i) * catalanRecursive(n - i - 1);
        }

        return result;
    }

    public long fact(int n){
        long fact = 1;
        for(int i=1;i<=n;i++){

            fact *= i;
        }

        return fact;
    }
}
