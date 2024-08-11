package RecursionPractice;

public class skipACharacter {
    public static void main(String[] args) {
        String s="aabbcaadta";
        skipChar("", s);
        System.out.println(getSkip( s));
        System.out.println(skipWord("aabaappleiiyaappleis","apple"));
    }

    public static void skipChar(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch =='a')
            skipChar(p, up.substring(1));
        else    
            skipChar(p + ch, up.substring(1));
    }

    public static String getSkip(String up){
        if(up.isEmpty()){
            //System.out.println(p);
            return "";
        }
        char ch = up.charAt(0);
        if(ch =='a')
            return getSkip(up.substring(1));
        else    
            return ch + getSkip(up.substring(1));
    }

    public static String skipWord(String up, String word){
        if(up.isEmpty()){
            //System.out.println(p);
            return "";
        }
        char ch = up.charAt(0);
        if(up.startsWith(word))
            return skipWord(up.substring(word.length()),word);
        else    
            return ch + skipWord(up.substring(1),word);
    }



}
