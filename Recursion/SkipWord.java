package Recursion;

public class SkipWord {
    static StringBuilder result = new StringBuilder();
    private static String remove;
    public static void main(String[] args){
        System.out.println(remove("caabbcaadcab",0,"ca"));
        System.out.println(skip("caabbcaadcab","ca"));
        String S="aabaaplecbbacbcbapp";
        System.out.println("App not Apple:"+skipAppNotApple(S, "app", "apple"));
    }
    /**
     *1st Approach : Remove/skip occurences of  a string from a string     
     e.g S="aabcbbacbcb"
     target="bc" i.e remove all occurences of bc from strig s.
     */
    public static String remove(String s, int index, String target){
        if(index==s.length()) return result.toString();
        String temp = s.substring(index, s.length());
        if(!temp.startsWith(target)){
            result.append(temp.charAt(0));
            return remove(s, index+1, target);
        } 
        else 
            return remove(s,index+target.length(),target);       

    }
    /**
     *2nd Approach : Remove/skip occurences of  a string from a string     
     e.g S="aabcbbacbcb"
     target="bc" i.e remove all occurences of bc from strig s.
     */

    public static String skip(String s, String target){
        if(s.isEmpty()) return "";
        if(s.startsWith(target))
            return skip(s.substring(target.length()),target);
        else
            return s.charAt(0) + skip(s.substring(1), target);
    }

    /**
     *1st Approach : Skip app but not apple   
     e.g S="aabaaplecbbacbcbapp"
     target="bc" i.e remove all occurences of app from strig s only if its not apple.
     * @param string TODO
     */

    public static String skipAppNotApple(String s, String target1,String target2){
        if(s.isEmpty()) return "";
        if(s.startsWith(target1) && !s.startsWith(target2))
            return skipAppNotApple(s.substring(target1.length()),target1,target2);
        else
            return s.charAt(0) + skipAppNotApple(s.substring(1), target1,target2);
    }

    
}
