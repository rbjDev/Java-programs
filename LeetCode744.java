//https://leetcode.com/problems/find-smallest-letter-greater-than-target/submissions/
/*
Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.

Note that the letters wrap around.

    For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.

*/
public class LeetCode744 {
    public static void main(String args[]){
        char letters[] = {'c','f','j'};
        System.out.println("Output:" + nextGreatestLetter(letters, 'g'));

    }
    
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length-1;
       // if(target < letters[0] || target >= letters[end]) return letters[0];        
        while(start<=end){
            int mid = start + (end-start)/2 ;
            if(target < letters[mid])
                end= mid - 1;
            else 
                start = mid + 1;     
                
        }
        return letters[start % letters.length];
    }

}
