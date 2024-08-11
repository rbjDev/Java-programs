package RecursionPractice;

import java.util.ArrayList;
import java.util.List;

public class PrintPermutations {
    public static void main(String[] args) {
        // printPermutations("", "abc");
        // System.out.println(getPermutations("", "pqr"));
        System.out.println(permute(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> p= new ArrayList<>();
        List<Integer> up= new ArrayList<>();
        for(int i:nums){
            up.add(i);
        }
        return getPermutationsList(p,up);
    }

    public static List<List<Integer>> getPermutationsList(List<Integer> p, List<Integer> up){
        List<List<Integer>> list = new ArrayList<>();
        if(up.isEmpty()){
            list.add(new ArrayList<>(p));
            return list;
        }
        int digit = up.get(0);
        for(int i=0;i<=p.size();i++){
            List<Integer> left = p.subList(0,i);
            List<Integer> right = p.subList(i,p.size());
            List<Integer> temp = new ArrayList<>(left);
            temp.add(digit);
            temp.addAll(right);
            list.addAll(getPermutationsList(temp, up.subList(1, up.size())));            
        }
        return list;
    }

    static void printPermutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch= up.charAt(0);
        for(int i=0;i<=p.length();i++){
            printPermutations(p.substring(0, i) + ch + p.substring(i), up.substring(1));
        }
    }

    static List<String> getPermutations(String p, String up){
        List<String> list = new ArrayList<>();
        if(up.isEmpty()){
            //System.out.println(p);
            list.add(p);
            return list;
        }
        char ch= up.charAt(0);
        for(int i=0;i<=p.length();i++){
            list.addAll(getPermutations(p.substring(0, i) + ch + p.substring(i), up.substring(1)));
        }
        return list;
    }
}
