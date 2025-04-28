package fibonaccistyle;

public class FibonacciNumbers {

    public int  fib(int n){
        int[] lookup = new int[n+1];

        for(int i=0;i<=n;i++){
            lookup[i] = Integer.MIN_VALUE;
        }

        return topDown(n);
    }


    public int bottomUp(int n){
        if(n==0  ) return 0;
        if(n==1 ) return 1;
        int[] fib = new int[n+1];

        fib[0] = 0;
        fib[1] = 1;

        for(int i =2; i <= n; i++){
            fib[i] = fib[i-2] + fib[i-1];
        }

        return fib[n];
    }

    public int topDown(int n){

        int[] fib = new int[n+1];

        return solveTopDown(n,fib);

    }

    public  int solveTopDown(int n, int[] memo){

        if(n==0) return 0;
        if(n==1) return 1;

        if(memo[n]!=0) return memo[n];

        memo[n] = solveTopDown(n-1,memo) + solveTopDown(n-2,memo);

        return memo[n];

    }
}
