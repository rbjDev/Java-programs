import java.util.Arrays;

public class CoinChangeMinNoOfCoins {
    public static void main(String args[])
    {
       int coins[] =  {186,419,83,408};
       int m = coins.length;
       int V = 6249;
       int dp[] = new int[V+1];
       Arrays.fill(dp,-1);
       System.out.println("Minimum coins required is "+ minCoins(coins, m, V,dp) );
       System.out.println("Minimum coins required is "+ minCoins(coins, m, V) );
       System.out.println(coinChange(coins, V));
    }

    //GFG solution

    static int minCoins(int coins[], int m, int V,int dp[])
    {
       // base case
       if (V == 0) return 0;

       if(dp[V]!=-1) return dp[V];
      
       // Initialize result
       int res = Integer.MAX_VALUE;
      
       // Try every coin that has smaller value than V
       for (int i=0; i<m; i++)
       {
         if (coins[i] <= V)
         {
             int sub_res = minCoins(coins, m, V-coins[i],dp);
      
             // Check for INT_MAX to avoid overflow and see if
             // result can minimized
             if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                res = sub_res + 1;
         }
       }
       dp[V] = res;
       return res;
    }

     //GFG solution
    static int minCoins(int coins[], int m, int V)
    {
        // table[i] will be storing 
        // the minimum number of coins
        // required for i value. So 
        // table[V] will have result
        int table[] = new int[V + 1];
 
        // Base case (If given value V is 0)
        table[0] = 0;
 
        // Initialize all table values as Infinite
        for (int i = 1; i <= V; i++)
        table[i] = Integer.MAX_VALUE;
 
        // Compute minimum coins required for all
        // values from 1 to V
        for (int i = 1; i <= V; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++)
            if (coins[j] <= i)
            {
                int sub_res = table[i - coins[j]];
                if (sub_res != Integer.MAX_VALUE 
                       && sub_res + 1 < table[i])
                       table[i] = sub_res + 1;
                        
                 
            }
             
        }
       
          if(table[V]==Integer.MAX_VALUE)
            return -1;
       
        return table[V];
         
    }

    public static int coinChange(int[] coins, int amount) {
        int table[] = new int[amount+1];
        table[0]=0;
        Arrays.fill(table,1,amount+1,Integer.MAX_VALUE);
        for(int i=1;i<=amount;i++){
            for(int j =0;j<coins.length;j++){
                if(coins[j]<=i){
                    int min = table[i-coins[j]];
                    if(min!=Integer.MAX_VALUE && min+1<table[i]){
                        table[i] = min +1;
                    }
                }
            }
        }
        if(table[amount]==Integer.MAX_VALUE) return -1;
        return table[amount];
    }
}
