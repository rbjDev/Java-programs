package LinkedList;

public class DoublyLinkedListDriver {
    public static void main(String args[]){
        DLL dll = new DLL();
        for(int i=1;i<10;i++){
            dll.addLast(i);
        }
        dll.display();
        dll.displayReverse();
        System.out.println("Size:"+ dll.size());
        dll.add(25, 3);
        dll.display();

        
    }
}
