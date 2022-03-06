/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * 387. First Unique Character in a String
Easy

Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 */
import java.util.*;
public class LeetCode387 {
    public int firstUniqChar(String s) {
        Queue<Character> queue = new LinkedList<Character>();
        int countArray[] = new int[24];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int index = c - 'a';
            countArray[index]++;
            if(queue.isEmpty()) queue.add(c);
            else if(queue.peek()==c) queue.add(c);



        }

        return -1;
        
      }
}
