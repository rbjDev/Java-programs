public class CountNoOfSubsetsWithGivenDifference {
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,2};
        int diff=1;
        System.out.println(countNoOfSubsetWithDiff(arr,diff));
    }

    private static int countNoOfSubsetWithDiff(int[] arr, int diff) {
        int sum = 0;
        for(int i:arr){
            sum+= arr[i];
        }
        int subsetSum1 = ( diff + sum ) / 2;
        return countSubsetSumTopDownDP(arr, subsetSum1, arr.length);
    }

    private static int countSubsetSumTopDownDP(int[] arr, int sum, int length){
        int table[][] = new int[length+1][sum+1];
        for(int i=0;i<length;i++)
            table[i][0] = 1;
        for(int i=1 ; i<length+1 ; i++){
            for(int j=1 ; j<sum+1 ; j++){
                //if value is greater than sum
                if(arr[i-1] > j){
                    table[i][j] = table[i-1][j];
                }
                else{
                    table[i][j] = table[i-1][j] + table[i-1][j-arr[i-1]];
                }
            }
        }
        return table[length][sum];
    }
}
