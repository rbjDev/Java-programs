/**https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * 1342. Number of Steps to Reduce a Number to Zero
Easy

Given an integer num, return the number of steps to reduce it to zero.

In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 */
package Recursion;

public class LeetCode1342 {

    public static void main(String args[]){        
        int n = 14;          
        System.out.println("Number of steps to reduce to zero:" + numberOfSteps(n));
    }

    public static int numberOfSteps(int num) {
        if(num==0) return 0;
        return count(num);
    }
    public static int count(int num){
        if(num==0) return 0;
        int steps =0;
        if(num%2==0)
            steps= count(num/2);
        else
            steps =count(num-1);
        return 1 + steps;
    }
    
}
