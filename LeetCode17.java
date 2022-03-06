import java.util.*;
/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Leetcode-17. Letter Combinations of a Phone Number
Medium

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 */

public class LeetCode17 {
    public static void main(String args[]){
        System.out.println("Combinations:"+ letterCombinations(""));           
    }
    public static List<String> letterCombinations(String digits) {  
        if(digits.isEmpty()) return new ArrayList<>();
          
        String arr[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        return getCombinations("",digits, arr);
    }

    public static List<String> getCombinations(String p,String up,String arr[]){
        List<String> list = new ArrayList<>();
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        int digit = up.charAt(0)-'0';
        String s = arr[digit];
        for(int i=0;i<s.length();i++){
            list.addAll(getCombinations(p + s.charAt(i), up.substring(1), arr));
        }
        return list;
    }

    
    
}
