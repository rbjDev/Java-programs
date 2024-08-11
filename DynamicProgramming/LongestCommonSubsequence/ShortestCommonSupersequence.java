package LongestCommonSubsequence;
/**
 * Given two strings str1 and str2, the task is to find the length of the shortest string that has both str1 and str2 as subsequences.
Eg str1 = "geek", str2 = "eke"
O/P : 5 as the string "geeke" contains both "geek" and "eke" as subsequences

    Now 1 way is simply adding both strings i.e "geekeke" (length=7)
    This string has both "geek" and "eke" as subsequences
    but this is not the shortest since "geeke" also has both "geek" and "eke" as subsequences
    One thing to note here is that LCS here is "ek" and actually we added "ek" twice in the "geekeke"
    so removing it once will serve us the purpose
    Once we find LCS, we insert characters of both strings in order and we get "geeke" So we can simply find the length of the SCS as :
    So length of the SCS = length of string 1 + length of string 2 - LCS

 */

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String text1 = "pmjghexybyrgzczy", text2 = "hafcdqbgncrcbihkd";
        
        System.out.println("Length of shortest common subsequence: " + (text1.length()+text2.length() - LCSTopDown(text1,text2)));
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
