package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String str, String pattern ) {
        List<Integer> anagrams = new ArrayList<>();
        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0, right = 0;
        int count = 0;
        int patternLength = pattern.length();

        // prepare frequency map by iterating over pattern
        for (Character c : pattern.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        // initialize count by size of frequency map to represent number of distinct
        // characters in pattern
        count = freqMap.size();

        // run till right pointer is less than length of the string
        while (right < str.length()) {

            // get the right most char
            char ch = str.charAt(right);

            // see if the char is there in frequency map
            if (freqMap.containsKey(ch)) {
                // decrease the count of frequency by 1
                freqMap.put(ch, freqMap.get(ch) - 1);

                // check if the frequency count of the char became 0, then reduce the count as
                // well by 1
                if (freqMap.get(ch) == 0) {
                    count--;
                }
            }

            // see if the window side is still not reached, then increase the right pointer
            // only
            if (right - left + 1 < patternLength) {
                right++;
            } else if (right - left + 1 == patternLength) { // if window size is same as pattern lenght both ptr will be
                                                            // increased by 1

                // verify at this time if count is 0, means we are able to match the freq of all
                // chars in freq map,
                // add the left index to the result list
                if (count == 0)
                    anagrams.add(left);
                // now since we need to shrink the window, we need add on logic
                // find the left char of the window
                Character leftChar = str.charAt(left);

                // if the left char is present in the freqMap
                // we are going to increase the frequency for this char by 1 in freq map
                // also if the freq of this char became greater than 0 this time, then we will
                // increase the count variable also by 1
                if (freqMap.containsKey(leftChar)) {
                    freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                    if (freqMap.get(leftChar) > 0) {
                        count++;
                    }
                }

                // finally shift the window by sliding both pointers
                left++;
                right++;
            }

        }
        return anagrams;
    }

    public static int countAnagrams(String s, String p) {
        int count = 0, anagrams =0 ;
        int length = s.length();
        int left = 0, right = 0, k = p.length();
        Map<Character,Integer> freqMap = new HashMap<>();
        for(char c: p.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        count = freqMap.size();
        while(right < length){
            char c = s.charAt(right);

            if(freqMap.containsKey(c)){
                freqMap.put(c, freqMap.get(c)-1);
                if(freqMap.get(c)==0){
                    count--;
                }
            }

            if(right - left + 1 < k)
                right++;
            else if(right - left + 1 == k){
                if(count == 0){
                    anagrams++;
                }
                char leftChar = s.charAt(left);
                if(freqMap.containsKey(leftChar)){
                    freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                    if(freqMap.get(leftChar)>0)
                        count ++;
                }
                left++;
                right++;
            }
        }
        return anagrams;
        
    }


}
