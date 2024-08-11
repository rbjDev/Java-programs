package RecursionPractice;

public class CountZeros {
    public static void main(String[] args) {
        int n = 9080;
        int arr[] = {2,2,1};
        //System.out.println(countZeros(n));
        System.out.println(singleNumber(arr));
    }

    private static int countZeros(int n) {
        return helper(n,0);
    }

    private static int helper(int n, int count) {
        if(n==0) return count;
        int rem = n%10;
        if(rem==0) return helper(n/10, count+1);
        else return helper(n/10, count);
    }

    public static int singleNumber(int nums[]){
        int result = 0; 
        for(int i:nums){
            result ^= i;
        }
        return result;
    }


}
