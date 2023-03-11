import java.util.ArrayList;
import java.util.List;

class SearchArrayRecursion{
    public static void main(String args[]){
        int arr[] = {3,5,1,9,1,3,1};
        //System.out.println(findAllIndex(arr,1,0,new ArrayList<Integer>()));
        System.out.println(findAllIndexWithoutArrayList(arr,1,0));
    }

    private static ArrayList<Integer> findAllIndex(int[] arr,int target, int index, ArrayList<Integer> arrayList) {
        if(index==arr.length) return arrayList;
        if(arr[index]==target) arrayList.add(index);
        return findAllIndex(arr, target, index+1, arrayList);
    }

    private static ArrayList<Integer> findAllIndexWithoutArrayList(int[] arr,int target, int index) {
        ArrayList<Integer> arrayList = new ArrayList<>(); 
        if(index==arr.length) return arrayList;               
        if(arr[index]==target) arrayList.add(index);
        arrayList.addAll(findAllIndexWithoutArrayList(arr, target, index+1));
        return arrayList;
    }
}