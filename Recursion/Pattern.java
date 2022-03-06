package Recursion;

public class Pattern {
    public static void main(String[] args){
        System.out.println("Pattern:");
        pattern2(5, 0);
    }
    /**
     * Pattern:
        *****
        ****
        ***
        **
        *
     */
    public static void  printPattern(int r, int c){
        if(r==0) return;
        if(c<r){
            System.out.print("*");
            printPattern(r, c+1);
        }
        else{
            System.out.println();
            printPattern(r-1, 0);
        }
    }

    public static void pattern2(int r, int c){
        if(r==0) return;
        if(c<r){            
            pattern2(r, c+1);
            System.out.print("*");
        }
        else{
            
            pattern2(r-1, 0);
            System.out.println();
        }
    }
}
