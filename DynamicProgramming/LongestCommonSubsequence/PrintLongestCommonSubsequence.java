package LongestCommonSubsequence;

public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        // String text1 = "acbcf";
        // String text2 = "abcdaf";
        String text1 = "pmjghexybyrgzczy", text2 = "hafcdqbgncrcbihkd";
        System.out.println(getLCSTopDown(text1, text2));
    }

    public static String getLCSTopDown(String text1, String text2){
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
        //return t[m][n];
        int i=m,j=n;
        StringBuilder lcs = new StringBuilder();
        while(i>0 && j>0){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                lcs.append(text1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(t[i-1][j] > t[i][j-1])
                    i--;
                else
                    j--;
            }
        }
        return lcs.reverse().toString();
    }
}
