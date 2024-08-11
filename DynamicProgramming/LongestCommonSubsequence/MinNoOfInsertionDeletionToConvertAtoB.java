package LongestCommonSubsequence;

public class MinNoOfInsertionDeletionToConvertAtoB {
    public static void main(String[] args) {
        String word1 = "sea", word2= "eat";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] t = new int[m+1][n+1];
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    t[i][j] = t[i-1][j-1]+1;
                }
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return ((m - t[m][n]) + (n - t[m][n]));
    }
}
