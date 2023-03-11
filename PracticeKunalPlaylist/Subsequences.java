package PracticeKunalPlaylist;

import java.util.ArrayList;

public class Subsequences {
    public static void main(String args[]){
        //System.out.println(getSubsequences("","abc"));
        //System.out.println(countMatchingSubsequences("", "bccbcdcabadabddbccaddcbabbaaacdba", "bccbbdc"));//TLE for the given input string
        System.out.println("Count:" + countSubsequences("", "abc"));
    }

    private static ArrayList<String> getSubsequences(String p, String up) {
        ArrayList<String> list = new ArrayList<>();
        if(up.isEmpty()) {
            System.out.println(p);
            if(!p.isEmpty())
                list.add(p);
            return list;            
        }
        list.addAll(getSubsequences(p+up.charAt(0), up.substring(1))); //left branch
        list.addAll(getSubsequences(p, up.substring(1))); //right branch
        return list;

    }

    private static Integer countMatchingSubsequences(String p, String up, String t) {
        ArrayList<String> list = new ArrayList<>();
        if(up.isEmpty()) {            
            if(!p.isEmpty() && p.equalsIgnoreCase(t))
                return 1;
            else return 0;
                      
        }
        Integer sum = countMatchingSubsequences(p+up.charAt(0), up.substring(1),t) +  countMatchingSubsequences(p, up.substring(1),t);
        return sum;
    }

    private static Integer countSubsequences(String p, String up) {
        //ArrayList<String> list = new ArrayList<>();
        if(up.isEmpty()) {
            System.out.println(p);
            if(!p.isEmpty())
                return 1;
            return 0;            
        }
        return countSubsequences(p+up.charAt(0), up.substring(1)) + countSubsequences(p, up.substring(1)); 
        

    }
}
