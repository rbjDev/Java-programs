public class CountOfSubsetsSum {
    public static void main(String[] args) {
        int arr[] = {1,2,3,3};
        int sum = 6;
        System.out.println(countSubsetSumTopDownDP(arr, sum, arr.length));

        int nums[] = {1,0};
        int sum1 =1;
        int target = 1;
        int s2 = (sum1-target)/2;
        System.out.println(countSubsetSumTopDownDP(nums, s2, nums.length));


    }

    private static int countSubsetSumTopDownDP(int[] arr, int sum, int length){
        int table[][] = new int[length+1][sum+1];
        //for(int i=0;i<length;i++)
            table[0][0] = 1;
        for(int i=1 ; i<length+1 ; i++){
            for(int j=0 ; j<sum+1 ; j++){
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
