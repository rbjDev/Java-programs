import java.util.Arrays;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = price.length;
        int length[] = new int[n];
        for (int i = 0; i < n; i++) {
            length[i] = i + 1;
        }
        System.out.println(
            "Maximum obtained value is " + unboundedKnapsackTopDown(length, price, n));
        
    }

    /**
     * 
     * Comparison with Unbounded knapsack:
     * values[] -> prices[]
     * weight[] -> length[]
     * knapsackweight -> length[].length
     */

    private static int unboundedKnapsackTopDown(int[] length, int[] prices, int knapsackWeight){
        int table[][] = new int[length.length+1][knapsackWeight+1];
        
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table[0].length;j++){
                if(i==0 ||j==0)
                    table[i][j]=0;
            }
        }
        for(int i=1 ; i<length.length+1 ; i++){
            for(int j=1;j< knapsackWeight+1 ; j++){
                if(length[i-1]>j){
                    table[i][j] = table[i-1][j];
                }
                else{
                    table[i][j] =  Integer.max((prices[i-1] + table[i][j-length[i-1]]), table[i-1][j]);                    
                }
            }
        }
        return table[length.length][knapsackWeight];
        

    }
}
