package LinkedList;

public class SingleLinkedListDriver {
    public static void main(String args[]){
      
        LL list = new LL();
        for(int i =0 ;i<6;i++){
            list.insertEnd(i);
        }
             
        list.display();
        list.insertRecursive(3, 9);
        list.display();
    }
}
