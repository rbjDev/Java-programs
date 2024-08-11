package LongestCommonSubsequence;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String text1 = "abde";
        String text2 = "bzzz";
        System.out.println(LCSRecursive(text1, text2, text1.length(), text2.length(), 0));
        System.out.println(LCSTopDown(text1, text2, text1.length(), text2.length()));        
    }

    public static int LCSRecursive(String text1, String text2, int l1, int l2, int count){
        if(l1==0 || l2==0) return count;
        if(text1.charAt(l1-1)==text2.charAt(l2-1))
            count = LCSRecursive(text1, text2, l1-1, l2-1, count+1);
        else
            count = Integer.max(count, Integer.max(LCSRecursive(text1, text2, l1, l2-1, 0),
                LCSRecursive(text1, text2, l1-1, l2, 0)));
        return count;
        
    }

    public static int LCSTopDown(String text1, String text2, int l1, int l2){
        int t[][] = new int[l1+1][l2+1];
        int result=0;
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                    result = Integer.max(result, t[i][j]);
                }
                else
                t[i][j] = 0;
            }
        }
        return result;
    }
}
