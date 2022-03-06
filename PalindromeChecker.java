public class PalindromeChecker {
    public static void main(String[] args){
        String test = "ababac";
        System.out.println("Check:" + palindromeChecker(test));        
    }

    public static boolean palindromeChecker(String test){
        for(int i = 0; i<test.length()/2; i++){
            char s = test.charAt(i);
            char e = test.charAt(test.length() - 1 - i);
            if(s!=e) return false;
        }
        return true;
    }
    
}
