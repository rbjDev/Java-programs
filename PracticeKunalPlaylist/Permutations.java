package PracticeKunalPlaylist;

public class Permutations {
    
    public static void main(String args[]){
        printPermutations("", "abc");
        System.out.println(countPermutations("", "abc"));
    }

    public static void printPermutations(String p, String up){
        if(up.isEmpty()){
            if(!p.isEmpty()){
                System.out.println(p);                
            }
            return;
        }
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String left = p.substring(0,i);
            String right = p.substring(i, p.length());
            printPermutations(left+ch+right, up.substring(1));
        }
    }

    public static int countPermutations(String p, String up){
        if(up.isEmpty()){
            if(!p.isEmpty()){
                return 1;               
            }
            return 0;
        }
        int count = 0;
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String left = p.substring(0,i);
            String right = p.substring(i, p.length());
            count+= countPermutations(left+ch+right, up.substring(1));
        }
        return count;
    }


}
