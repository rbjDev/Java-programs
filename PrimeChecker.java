import java.util.Scanner;

public class PrimeChecker {
    public static void main(String args[]) {
        System.out.println("Enter a number:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        check(n);
        in.close();
    }
    public static void check(int n){
        if(n<2)
        System.out.println("Not prime!!");
        int c = 2;
        while(c*c<=n){
            if(n%c==0){
                System.out.println("Not prime!");
                return;
            } 
            c++;
        }
        System.out.println("Prime!!");
    }
}
