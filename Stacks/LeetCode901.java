package Stacks;

import java.util.Stack;

public class LeetCode901 {
    class StockSpanner {
        class pair{
            int value;
            int index;
            public pair(int index, int value){
                this.index =index;
                this.value = value;
            }
        }
        Stack<pair> stack;
        int index;
        
        public StockSpanner() {
            stack = new Stack<>();
            index =-1;
        }
        
        public int next(int price) {
            index++;            
            if(stack.isEmpty()){
                stack.push(new pair(index, price));
                return 1+index;
            }
            else if(stack.peek().value > price){
                stack.push(new pair(index, price));
                return index - stack.peek().index ;
            }
            else{
                while(!stack.isEmpty() && stack.peek().value<=price){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    stack.push(new pair(index, price));
                    return index +1;
                }
                else{
                    stack.push(new pair(index, price));
                    return index - stack.peek().index;
                }
            }
            
        }
    }
}
