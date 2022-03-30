package Queue;

import java.util.Stack;

public class DynamicStack extends CustomStack {
    public DynamicStack(){
        super();
    }

    public DynamicStack(int size){
        super(size);
    }

    @Override
    public boolean push(int val) throws StackException{
        //this takes care if array is full
        if(this.isFull()){
            //double the size of the list
            int[] temp = new int[data.length*2];
            //copy the previous elements into the new array
            for(int i=0;i<data.length;i++){
                temp[i]=data[i];
            }
            data=temp;
        }

        return super.push(val);
    }
    
}
