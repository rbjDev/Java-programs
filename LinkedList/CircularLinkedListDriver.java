package LinkedList;

public class CircularLinkedListDriver {
    public static void main(String args[]){
        CLL cll = new CLL();
        for(int i=1;i<10;i++){
            cll.insertBeg(i);
        }
       cll.display();
       cll.delete(5);
       cll.display();

        
    }
}
