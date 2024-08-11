public class MinSubsetSumDifference {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int sum = 0;
        int length = arr.length;
        for(int i : arr){
            sum+= i;
        }
        boolean table[][] = subsetSumTopDown(arr,sum , arr.length);
        int minDiff = Integer.MAX_VALUE;
        for(int i=sum/2;i>=0;i--){
            if(table[length][i]){
                minDiff = sum - 2*i;
                break;
            }
        }
        System.out.println("Min subset sum difference: " + minDiff);

    }

    private static  boolean[][] subsetSumTopDown(int[] arr, int sum, int length){
        boolean table[][] = new boolean[length+1][sum+1];
        for(int i=0;i<length;i++)
            table[i][0] = true;
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
        return table;
    }
}
