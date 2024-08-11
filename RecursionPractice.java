public class RecursionPractice {
    public static void main(String[] args) {
        // System.out.println(sumOfDigits(1234));
        // System.out.println(countZeroes(100050, 0));
        // System.out.println(linearSearch(new int[]{1,5,9,4,3},12,5));
        printSubsets("", "abc");
       
    }

    static int sumOfDigits(int n){
        if(n==0) return n;
        int d = n%10;
        return d + sumOfDigits(n/10);
    }

    static int countZeroes(int n, int count){
        if(n==0) return count;
        int d = n%10;
        if(d==0)
            return countZeroes(n/10, count+1);
        else
            return countZeroes(n/10, count);
    }

    static int linearSearch(int arr[], int key, int n){
        if(n==0)
            return -1;
        if(arr[n-1] == key) return n-1;
        else
            return linearSearch(arr, key, n-1);
    }

    static void printSubsets(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch =up.charAt(0);
        printSubsets(p + ch, up.substring(1));
        printSubsets(p, up.substring(1));
    }
}
