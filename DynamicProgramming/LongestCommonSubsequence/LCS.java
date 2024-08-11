package LongestCommonSubsequence;

import java.util.Arrays;

public class LCS {
    static int t[][];
    public static void main(String[] args) {
        String text1 = "pmjghexybyrgzczy", text2 = "hafcdqbgncrcbihkd";
        //System.out.println(longestCommonSubsequenceRecursive(text1, text2));
        t = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<t.length;i++)
            Arrays.fill(t[i],-1);
           // System.out.println(longestCommonSubsequenceRecursiveMemoized(text1, text2,t));
        System.out.println(LCSTopDown(text1, text2));
        //printLCS(text1, text2);
        
    }

    public static int longestCommonSubsequenceRecursive(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();

        if(l1==0 || l2==0) return 0;
        if(text1.charAt(l1-1)==text2.charAt(l2-1))
            return 1 + longestCommonSubsequenceRecursive(text1.substring(0, l1-1), text2.substring(0, l2-1));

        else 
            return Integer.max(longestCommonSubsequenceRecursive(text1, text2.substring(0, l2-1)),
             longestCommonSubsequenceRecursive(text1.substring(0, l1-1), text2));
        
    }
    

    public static int longestCommonSubsequenceRecursiveMemoized(String text1, String text2, int t[][]) {
        int l1 = text1.length();
        int l2 = text2.length();

        if(l1==0 || l2==0) return 0;

        if(t[l1][l2]!=-1) return t[l1][l2];

        if(text1.charAt(l1-1)==text2.charAt(l2-1))
            t[l1][l2] = 1 + longestCommonSubsequenceRecursiveMemoized(text1.substring(0, l1-1), text2.substring(0, l2-1),t);

        else 
            t[l1][l2] = Integer.max(longestCommonSubsequenceRecursiveMemoized(text1, text2.substring(0, l2-1),t),
             longestCommonSubsequenceRecursiveMemoized(text1.substring(0, l1-1), text2,t));

        return t[l1][l2];
        
    }

    public static int LCSTopDown(String text1, String text2){
        int t[][] = new int[text1.length()+1][text2.length()+1];
        int m = text1.length();
        int n = text2.length();
        for(int i=1 ; i<=m ; i++){
            for(int j=1 ; j<=n ; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Integer.max(t[i][j-1], t[i-1][j]); 
            }
        }
        return t[m][n];
    }

    
        
}
