public class EqualSumPartitionProblem {
    public static void main(String[] args) {
        int nums[]={1,5,6,11};
        System.out.println(equalPartitionSum(nums));
    }

    private static boolean equalPartitionSum(int[] nums){
        int numsSum = 0;
        for(int i=0; i<nums.length ; i++){
            numsSum += nums[i];
        }
        if(numsSum%2 != 0)
            return false;
        else
            return subsetSumTopDown(nums, numsSum/2);
    }

    private static boolean subsetSumTopDown(int[] nums, int sum){
        boolean table[][] = new boolean[nums.length+1][sum+1];
        for(int i=0;i<nums.length;i++)
            table[i][0] = true;
        for(int i=1 ; i<nums.length+1 ; i++){
            for(int j=1 ; j<sum+1 ; j++){
                //if value is greater than sum
                if(nums[i-1] > j){
                    table[i][j] = table[i-1][j];
                }
                else{
                    table[i][j] = table[i-1][j] || table[i-1][j-nums[i-1]];
                }
            }
        }
        return table[nums.length][sum];
    }
}
