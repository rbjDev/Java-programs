/**
 * https://leetcode.com/problems/roman-to-integer/
 * 13. Roman to Integer
Easy

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.
 */
public class RomanToInteger {
    public static void main(String args[]){
        String s = "LVIII"; //"MCMXCIV"
        System.out.println("Roman to Integer:" + romanToInt(s));
    }


    public static int romanToInt(String s) {
        
        int i=0;
        int result = 0;
        while(i<s.length()){
            int left = getValue(s.charAt(i));
            if(i==s.length()-1){
                result+= left;
                break;
            }              
            
            int right = getValue(s.charAt(i+1));
            if(left<right) result-= left;
            else result+= left;
            i++;                
        }
        return result;
    }
    
    public static int getValue(char symbol){
        switch(symbol){
            case 'I': return 1; 
            case 'V': return 5; 
            case 'X': return 10; 
            case 'L': return 50; 
            case 'C': return 100; 
            case 'D': return 500; 
            case 'M': return 1000; 
            default: return 0;
                
        }
    }
    
}
