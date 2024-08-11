package RecursionPractice;

public class ReverseNumber {
    static int ans = 0;
    public static void main(String[] args) {
        int n=85679;
        reverse(n);
        System.out.println(ans);
        System.out.println(getReverse(n));
    }
    private static void reverse(int n) {
        if(n==0) return ;
        int rem = n % 10;
        ans = ans*10 + rem;
        reverse(n/10);
    }

    private static int getReverse(int n){
        return helper(n, (int)Math.log10(n)+1);
    }

    private static int helper(int n, int digits){
        if(n%10 == n) return n;
        int rem = n % 10;
        return rem * (int)Math.pow(10, digits-1) + helper(n/10, digits-1);

    }
}
