package RecursionPractice;

public class CheckIfArraySorted {
    public static void main(String[] args) {
        int arr[] =  {1,5,7,9,10,11,1};
        System.out.println(checkIfSorted(arr));
    }

    private static boolean checkIfSorted(int[] arr) {
        // TODO Auto-generated method stub
        return check(arr,0);
    }

    private static boolean check(int[] arr, int index) {
        if(index == arr.length-1)
            return true;
        return arr[index]<arr[index+1] && check(arr,index+1);
    }
}
