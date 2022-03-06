package Recursion;

public class Palindrome {
    public static void main(String args[]){
        System.out.println(palindrome(10));
        //int digits = (int) (Math.log10(5115) + 1);
    }

    public static boolean palindrome(int x){
        if(x<0) return false;
        StringBuilder value = new StringBuilder();
        value.append(x);
        StringBuilder reverse = value.reverse();
        System.out.println(reverse);
        if(value.equals(reverse)) return true;
        return false;
       
    }

    
}
