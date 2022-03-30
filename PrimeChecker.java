import java.util.HashMap;
import java.util.Scanner;

public class PrimeChecker {
    int x;
    int y;
    String name;
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PrimeChecker other = (PrimeChecker) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
    public static void main(String args[]) {
        System.out.println("Enter a number:");
        Scanner in = new Scanner(System.in);
        HashMap<Integer,String> map = new HashMap<>();
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
