package RecursionPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        String s = "pqr";
       // printSubsets("", s);
       // System.out.println(getSubsets("", "abc"));
       System.out.println();
        int nums[] = {1,2,3};
        //subsets(nums);    
        //System.out.println(subsets(nums)) ;
        // for(List<Integer> list: subsets(nums)){
        //     System.out.println(list);
        // }

        // List<Integer> subset = new ArrayList<>();
        // List<List<Integer>> subsetList = new ArrayList<>();
        // newSubset(nums, 0, subset, subsetList);
        // for(List<Integer> list: subsetList){
        //     System.out.println(list);
        // }

        // for(List<Integer> list: subsetList){
        //     System.out.println(list);
        // }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> upp = new ArrayList<>();
        List<Integer> pp = new ArrayList<>();        
        for(int i:nums){
            upp.add(i);
        }        
        return findSubsets(pp,upp);   
        
    }

    private static List<List<Integer>> findSubsets(List<Integer> p,List<Integer> up ) {
        List<List<Integer>> list= new ArrayList<>();
        if(up.isEmpty()){
            list.add(new ArrayList<>(p));
            return list;
        }
        List<List<Integer>> rlist = findSubsets(new ArrayList<>(p), up.subList(1, up.size()));        
        p.add(up.get(0));
        List<List<Integer>> llist =findSubsets(new ArrayList<>(p), up.subList(1, up.size()));
        rlist.addAll(llist);
        return rlist;
    }

    private static void  newSubset(int nums[],int i,List<Integer> subset,List<List<Integer>> subsetList){
        if(i==nums.length)
            subsetList.add(new ArrayList<>(subset));
        else{
            List<Integer> temp = new ArrayList<>(subset);
            temp.add(nums[i]);
            newSubset(nums,i+1,temp,subsetList);
            newSubset(nums,i+1,new ArrayList<>(subset),subsetList);
        }

    }

    public static void printSubsets(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        printSubsets(p + up.charAt(0), up.substring(1));
        printSubsets(p, up.substring(1));
    }

    public static ArrayList<String> getSubsets(String p, String up){
        ArrayList<String> list = new ArrayList<>();
        if(up.isEmpty()){
            //System.out.println(p);
            list.add(p);
            return list;
        }
        list.addAll(getSubsets(p + up.charAt(0), up.substring(1)));
        list.addAll(getSubsets(p, up.substring(1)));
        return list;
    }
}
