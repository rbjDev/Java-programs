import java.util.Arrays;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "The sky is           blue   ";
        StringBuilder result = new StringBuilder();
        String[] str = s.trim().split("\\s+");
        System.out.println(Arrays.toString(str));
        for(int i=str.length-1; i>0 ; i--){
            result.append(str[i]).append(" ");
        }
        result.append(str[0]);
        System.out.println(result.toString());
        String[] fruits = {"Apple", "App", "Ape"};
        longestCommonPrefix(fruits);
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        int index = 0;
        for(int i = 0; i<first.length() && i<last.length() ;i++){
            
            if(first.charAt(i)==last.charAt(i))
                index++;
            else
                 break;
        }
        return first.substring(0,index);
    }

    public boolean rotateString(String s, String goal) {
        String superString = s + s;
        if(superString.contains(goal))
            return true;
        else 
            return false;
    }



    
}
