package Stacks;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String args[]){
        // String s = "((())()))";
        // int left = 0, right=0;
        // for(int i=0;i<s.length();i++){
        //     char c = s.charAt(i);
        //     if(c=='(') left++;
        //     else if(c==')'){
        //         if(left==0){
        //             right=1;
        //             break;
        //         }
        //         else
        //             left--;
        //     }
        // }
        // if(right>0) System.out.println("Not valid!");
        // else System.out.println("Valid!!");

        String s="((()))";
        System.out.println("Is valid ? "+isValid(s));
    }

    public static boolean isOpeningBracket(char c){
        if(c=='(' || c=='{' || c=='[')
            return true;
        return false;
    }

    public static boolean isClosingBracket(char c){
        if(c==')' || c=='}' || c==']')
            return true;
        return false;
    }

    public static char getOpeningBracket(char c){
        if(c==')') return '(';
        if(c=='}') return '{';
        if(c==']') return '[';
        else return ' ';
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length()%2 == 1)
        return false;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(isOpeningBracket(c)){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()) return false;
                if(stack.peek()==getOpeningBracket(c)){
                    stack.pop();
                }
                else
                    return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
