import java.util.Arrays;

public class SubsetSumProblem{
    static int t[][];
    public static void main(String[] args) {
        int arr[]={3, 34, 4, 12, 5, 2};
        int sum =9;      
        
        //System.out.println(subsetSumExistsRecursive(arr,sum,arr.length));
        //System.out.println(isSubsetSumMemoized(arr, sum, arr.length));
        System.out.println(subsetSumTopDown(arr, sum, arr.length));
        //System.out.println(countSumExistsRecursive(arr, sum, arr.length));
    }

    public static boolean isSubsetSumMemoized(int[] arr, int sum, int length){
        t = new int[arr.length+1][sum+1];
        for(int i=0;i<t.length;i++){
            Arrays.fill(t[i], -1);
        }
        return subsetSumExistsHelper(arr, sum, length);
    }

    private static boolean subsetSumExistsHelper(int[] arr, int sum, int length) {
        
        if(sum==0) return true;
        if(length==0)return false;
        if(t[length][sum]!=-1)
            return t[length][sum]==1;
        if(arr[length-1]>sum){
            t[length][sum] =  subsetSumExistsHelper(arr, sum, length-1) ? 1 : 0;
        }
        else{
            t[length][sum] =  (subsetSumExistsHelper(arr, sum-arr[length-1], length-1) || subsetSumExistsHelper(arr, sum, length-1)) ? 1 : 0;
        }
        return t[length][sum] ==1 ;
    }

    private static boolean subsetSumExistsRecursive(int[] arr, int sum, int length) {
        
        if(sum==0) return true;
        if(length==0)return false;
        if(arr[length-1]>sum){
            return subsetSumExistsRecursive(arr, sum, length-1);
        }
        else{
            return subsetSumExistsRecursive(arr, sum-arr[length-1], length-1) || subsetSumExistsRecursive(arr, sum, length-1);
        }
    }

    private static int countSumExistsRecursive(int[] arr, int sum, int length) {
        
        if(sum==0) return 1;
        if(length==0)return 0;
        if(arr[length-1]>sum){
            return countSumExistsRecursive(arr, sum, length-1);
        }
        else{
            return countSumExistsRecursive(arr, sum-arr[length-1], length-1) + countSumExistsRecursive(arr, sum, length-1);
        }
    }

    private static boolean subsetSumTopDown(int[] arr, int sum, int length){
        boolean table[][] = new boolean[length+1][sum+1];
        table[0][0] = true;
        for(int i=1 ; i<length+1 ; i++){
            for(int j=1 ; j<sum+1 ; j++){
                //if value is greater than sum
                if(arr[i-1] > j){
                    table[i][j] = table[i-1][j];
                }
                else{
                    table[i][j] = table[i-1][j] || table[i-1][j-arr[i-1]];
                }
            }
        }
        return table[length][sum];
    }


    
}