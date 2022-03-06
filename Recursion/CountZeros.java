package Recursion;
/**
 * Count number of zero digits in an integer recursively.
 */
public class CountZeros {
    public static void main(String args[]){
        
        int n = 10065;    
        if(n==0)
        System.out.println("Zero count:" + 1);
        else   
        System.out.println("Zero count:" + countZero(n));
    }

    public static int countZero(int n){
        if(n==0) return 0; 
        int d = n%10;
        if(d==0) return 1 + countZero(n/10);
        else return countZero(n/10);

    }
}
