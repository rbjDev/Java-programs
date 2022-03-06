package Recursion;

public class ReverseNumber {
    public static void main(String args[]){
        
        int digits = (int) (Math.log10(10052) + 1);
        
        System.out.println("Reverse:" + reverse(10052,digits));
    }

    public static int reverse(int x,int digits){
        if(digits==1) return x;
        int rem = x%10;
        return rem* (int)(Math.pow(10,digits-1)) + reverse(x/10, digits-1);
    }
}
