package LinkedList;

import java.util.LinkedList;

public class BasicLinkedList {
    public static void main(String args[]){
        // LinkedList<Integer> list = new LinkedList<>();
        // list.add(5);
        // list.add(10);
        // list.add(5);
        // list.add(10);
        // System.out.println("Linked list:" + list);
        LL list = new LL();
        for(int i =0 ;i<6;i++){
            list.insertFirst(i*2);
        }
        // list.display();
        // list.insertEnd(1);
        // list.display();
        // list.deleteFirst();
        // list.display();
        // list.deleteLast();
        list.display();
        list.delete(0);
        list.display();
        
    }
}
