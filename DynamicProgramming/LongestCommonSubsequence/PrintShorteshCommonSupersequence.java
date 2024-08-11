package LongestCommonSubsequence;

public class PrintShorteshCommonSupersequence {
    public static void main(String[] args) {
        String str1 = "abac", str2 = "cab";
        System.out.println("ShortestCommonSupersequenceString:" + getShortestCommonSupersequenceString(str1, str2));
    }

    public static String getShortestCommonSupersequenceString(String str1, String str2){
        StringBuilder result = new StringBuilder();
        String lcs = getLCSTopDown(str1, str2);
        int i=0,j=0;
        for(char c:lcs.toCharArray()){
            while(str1.charAt(i)!=c){
                result.append(str1.charAt(i));
                i++;
            }
            while(str2.charAt(j)!=c){
                result.append(str2.charAt(j));
                j++;
            }
            result.append(c);
            i++;
            j++;                
        }
        result.append(str1.substring(i));
        result.append(str2.substring(j));
        return result.toString();

    }

    public static String getLCSTopDown(String str1, String str2){
        int t[][] = new int[str1.length()+1][str2.length()+1];
        int m = str1.length();
        int n = str2.length();
        for(int i=1 ; i<=m ; i++){
            for(int j=1 ; j<=n ; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Integer.max(t[i][j-1], t[i-1][j]); 
            }
        }
        //return t[m][n];
        int i=m,j=n;
        StringBuilder lcs = new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                lcs.append(str1.charAt(i-1));
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
