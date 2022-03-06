import java.util.Arrays;
import java.util.HashMap;

public class FirstNonRepeatingChar {
    public static void main(String args[]){
        String s= "aadadaad";
        //System.out.println(firstNonRepChar(s)==-1 ? "No non-repeating characters found!!" : s.charAt(firstNonRepChar(s)));
        //System.out.println(firstNonRepChar(s)==-1 ? "No non-repeating characters found!!" : s.charAt(getFirstNonRepeatingCharIndex(s)));
        System.out.println(findIndex(s)==-1 ? "No non-repeating characters found!!" : s.charAt(findIndex(s)));
    }

    /**
     * Count Array approach    
     * Time: O(n)
     * Space: O(1)
     * String traversal : twice 
     */
    public static int firstNonRepChar(String s){
        int count[] = new int[256];
        int index=-1;
        Arrays.fill(count, 0);
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)]++;
        }
        for(int i=0;i<s.length();i++){
            if(count[s.charAt(i)]==1){
                index=i;
                break;
            }
        }
        return index;
    }

    /**
     * HashMap Approach
     * Time: O(n)
     * Space: O(1)
     * String traversal : twice
     * 
     * @param s
     * @return
     */
    public static int getFirstNonRepeatingCharIndex(String s){
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(map.get(c)==1) return i;
        }
        return -1;

    }
    /**
     * Count array approach
     * Time: O(n)
     * Space: O(1)
     * String traversal : once
     */

    public static int findIndex(String s){
        int count[] = new int[256];
        Arrays.fill(count,-1);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(count[c]==-1) count[c] = i;
            else count[c] = -2;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<count.length;i++){

            if(count[i]>=0 && count[i]<min) 
                min=count[i];

        }
        if(min==Integer.MAX_VALUE) return -1;
        else return min;

    }
}
