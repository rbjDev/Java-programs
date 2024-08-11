public class CoinChangeProblem1 {
    public static void main(String[] args) {
        int coins[] = {1,2,3};
        int n= 3;
        int sum = 4;
        System.out.println("Coin change: Max no of ways:" + countMaxWays(coins, sum, n));
        
    }

    public static int countMaxWays(int coins[],int sum,int n){
        if(sum==0) return 1;
        if(n==0) return 0;
        if(coins[n-1]>sum)
            return countMaxWays(coins, sum, n-1);
        else
            return countMaxWays(coins, sum, n-1) + countMaxWays(coins, sum-coins[n-1], n);
    }
}
