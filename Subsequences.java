import java.util.ArrayList;
/**
 * Kunal Kushwaha DSA bootcamp series
 * https://www.youtube.com/watch?v=gdifkIwCJyg 
 */

public class Subsequences {
    public static void main(String args[]){
        //printSubsequences("", "abc");
        System.out.println("Subsequences list: "+ getSubsequencesList("", "abcd"));
    }
    public static void printSubsequences(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        } 
        char c = up.charAt(0);
        printSubsequences(p+c,up.substring(1));
        printSubsequences(p, up.substring(1));

    }

    public static ArrayList<String> getSubsequencesList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list =  new ArrayList<>();
            list.add(p);
            return list;
        } 
        char c = up.charAt(0);
        ArrayList<String> finalList =getSubsequencesList(p+c,up.substring(1));
        finalList.addAll(getSubsequencesList(p, up.substring(1)));
        return finalList;

    }

    // public static void printSubsequencesIterative(String p){
    //     for(int i=0;i<p.length();i++){

    //     }
    // }
}
