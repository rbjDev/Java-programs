package LongestCommonSubsequence;

public class SequencePatternMatching {
    public static void main(String[] args) {
        String text1 = "acvt", text2 = "papnmvitp";
        int lcs = LCSTopDown(text1, text2);
        if(lcs==text1.length())
            System.out.println("True");
        else
            System.out.println("False");
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
