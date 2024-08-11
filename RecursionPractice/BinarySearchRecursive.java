package RecursionPractice;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        int arr[] = {2,5,9,15,23,56,99,102};
        System.out.println(binarySearchRecursive(arr,25,0,arr.length-1));
    }

    private static boolean binarySearchRecursive(int[] arr, int key, int s, int e) {
        if(s>e) return false;

        int mid = s + (e-s)/2;
        if(arr[mid] == key) return true;
        if(key<arr[mid])
            return binarySearchRecursive(arr, key, s, mid-1);
        else 
            return binarySearchRecursive(arr, key, mid+1, e);
        // TODO Auto-generated method stub
        
    }
}
