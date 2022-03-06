package Recursion;

public class SimpleLoop {
    public static void main(String args[]){
        loop(5);
    }

    public static void loop(int n){
        if(n==0)
        return;
        loop(n-1);
        System.out.println(n + " ");
    }
}
