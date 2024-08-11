public class TargetSum {
    public static void main(String[] args) {
        int nums[] = {0,0,0,0,0,0,0,0,1};
        int target = 1;
        System.out.println(findTargetSumWays(nums, target));
        System.out.println(findTargetSumWays1(nums, target));

    }

    public static int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        for(int x : nums)
            sum += x;
        if(((sum - target) % 2 == 1) || (target > sum))
            return 0;
        
        int n = nums.length;
        int s2 = (sum - target)/2;
        int[][] t = new int[n + 1][s2 + 1];
        t[0][0] = 1;
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < s2 + 1; j++) {
                if(nums[i - 1] <= j)
                    t[i][j] = t[i-1][j] + t[i - 1][j - nums[i - 1]];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][s2];
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+= nums[i];
        }
        if(((sum - target) % 2 == 1) || (target > sum))
            return 0;
        int s2 = (sum- target) / 2;
        return countSubsetSumTopDownDP(nums, s2, nums.length);
    }

    private static int countSubsetSumTopDownDP(int[] arr, int s2, int length){
        int table[][] = new int[length+1][s2+1];
        table[0][0] = 1;
        for(int i=1 ; i<length+1 ; i++){
            for(int j=0 ; j<s2+1 ; j++){
                //if value is greater than sum
                if(arr[i-1] > j){
                    table[i][j] = table[i-1][j];
                }
                else{
                    table[i][j] = table[i-1][j] + table[i-1][j-arr[i-1]];
                }
            }
        }
        return table[length][s2];
    }

}
