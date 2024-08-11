import java.util.Arrays;

public class KnapsackProblem { 
    static int t[][] ;
    public static void main(String[] args) {
        int values[] = {60,50,70,30};
        int weights[] = {5,3,4,2};
        int KnapsackWeight = 10;
        t= new int[values.length+1][KnapsackWeight+1];
        for(int i=0;i<t.length;i++){
            Arrays.fill(t[i], -1);
        }
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t[0].length;j++){
                if(i==0 ||j==0)
                    t[i][j]=0;
            }
        }
        //int maxProfit = knapsackRecursiveMemoization(values,weights,KnapsackWeight,values.length);
        System.out.println("Max profit: "+ knapsackTopDown(values, weights, KnapsackWeight) );
    }

    private static int knapsackRecursiveMemoization(int[] values, int[] weights, int knapsackWeight, int length) {
        if(knapsackWeight==0 || length==0)
            return 0;

        if(t[length][knapsackWeight]!=-1)
            return t[length][knapsackWeight];

        if(weights[length-1]<=knapsackWeight){
            int max = Integer.max((values[length-1] + knapsackRecursive(values, weights, knapsackWeight - weights[length-1], length-1))
                        , knapsackRecursive(values, weights, knapsackWeight , length-1));
            t[length][knapsackWeight] = max;
            return max;
        }
        else{
            int max = knapsackRecursive(values, weights, knapsackWeight , length-1);
            t[length][knapsackWeight] = max;
            return max;
        }
                    

    }

    private static int knapsackRecursive(int[] values, int[] weights, int knapsackWeight, int length) {
        if(knapsackWeight==0 || length==0)
            return 0;

        // Return the maximum of two cases:
        // 1. nth item included
        // 2. nth item not included
        if(weights[length-1]<=knapsackWeight){
            int max = Integer.max((values[length-1] + knapsackRecursive(values, weights, knapsackWeight - weights[length-1], length-1))
                        , knapsackRecursive(values, weights, knapsackWeight , length-1));
            return max;
        }
        else{
            // If the weight of the nth item is more than the knapsack capacity, it cannot be included
            int max = knapsackRecursive(values, weights, knapsackWeight , length-1);
            return max;
        }                    

    }

    private static int knapsackTopDown(int[] values, int[] weights, int knapsackWeight){
        int table[][] = new int[values.length+1][knapsackWeight+1];
        for(int i=1 ; i<values.length+1 ; i++){
            for(int j=1;j< knapsackWeight+1 ; j++){
                if(weights[i-1]>j){
                    table[i][j] = table[i-1][j];
                }
                else{
                    int max =  Integer.max(values[i-1] + table[i-1][j-weights[i-1]], table[i-1][j]);
                    table[i][j] = max;
                }
            }
        }
        return table[values.length][knapsackWeight];
        

    }

    
}
