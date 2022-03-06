package Recursion;
/**Remove a specific character from a string... */
public class RemoveCharacterFromString {
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args){
        System.out.println(remove("aabbccaad",0,'a'));
    }
    public static String remove(String s, int index, char target){
        if(index==s.length()) return result.toString();
        char c = s.charAt(index);
        if(c!=target) result.append(c);
        return remove(s, index+1, target);

    }
    
}
