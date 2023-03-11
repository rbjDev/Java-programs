public class SkipWord{
    public static void main(String args[]){
        System.out.println(skipAWord("aaaappleeeappleeeww", "apple"));
    }

    public static String skipAWord(String or, String word){
        if(or.isEmpty()){
            return "";
        }

        if(or.startsWith(word)){
            return skipAWord(or.substring(word.length()),word);
        }
        else{
            return or.charAt(0) + skipAWord(or.substring(1),word);
        }
    }
}