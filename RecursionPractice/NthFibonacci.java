package RecursionPractice;

import java.util.Arrays;

public class NthFibonacci {
    static int dp[];
    public static void main(String[] args) {
        int n=40;
        //System.out.println(fibo(n));
        
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(fibo(n));

    }

    public static int fibo(int n){
        if(n==0 || n==1) return n;
        return fibo(n-1) + fibo(n-2);
    }

    public static int fiboMemoized(int n){
        if(n<2) return n;
        if(dp[n]!=-1) return dp[n];

        dp[n] = fibo(n-1) + fibo(n-2);
        return dp[n];
    }
}
