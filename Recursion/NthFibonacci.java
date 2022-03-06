package Recursion;

public class NthFibonacci {
    public static void main(String args[]){
        System.out.println("3rd fibonacci number:" + getNthFibo(3));
    }

    public static int getNthFibo(int n){
        if(n<2) return n;
         
        return getNthFibo(n-1) + getNthFibo(n-2);
    }
}
