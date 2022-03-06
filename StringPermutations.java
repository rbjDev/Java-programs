import java.util.ArrayList;
/**
 * Recursion : Permutations
 * DSA bootcamp by Kunal kushwaha
 * https://www.youtube.com/watch?v=gDGw0cvFXPQ
 */
public class StringPermutations {
    public static void main(String args[]){
            //printPermutations("", "abc");
            System.out.println("Permutations:" + getPermutations("", "abc"));
            System.out.println("Permutations count:" + getPermutations("", "abc").size());
            System.out.println("Permutations count function:" + countPermutations("", "abcd"));
    }
    public static void printPermutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){ 
            String f = p.substring(0, i);
            String l = p.substring(i,p.length());
            printPermutations(f+ch+l, up.substring(1));
        }

    }

    public static ArrayList<String> getPermutations(String p, String up){
        ArrayList<String> list =  new ArrayList<>();
        if(up.isEmpty()){           
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){ 
            String f = p.substring(0, i);
            String l = p.substring(i,p.length());
            list.addAll(getPermutations(f+ch+l, up.substring(1)));
        }
        return list;

    }

    public static int countPermutations(String p, String up){
        
        if(up.isEmpty()){           
            return 1;
        }
        char ch = up.charAt(0);
        int count = 0;
        for(int i=0;i<=p.length();i++){ 
            String f = p.substring(0, i);
            String l = p.substring(i,p.length());
            count+= countPermutations(f+ch+l, up.substring(1));
        }
        return count;

    }
}
