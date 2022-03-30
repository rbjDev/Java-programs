package LinkedList;
/**
 * Custom circular-linked list implementation
 * DSA bootcamp by Kunal Kushwaha
 * https://www.youtube.com/watch?v=58YbpRDc4yw&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=44
 */
public class CLL {
    private Node head;
    private Node tail;

    public CLL(){
        this.head = null;
        this.tail = null;
    }

    public void insertEnd(int data){
        Node node = new Node(data);
        if(head==null){
            head = node;
            tail = node;
        }
        tail.next = node;
        node.next = head;
        tail = node;

    }

    public void insertBeg(int data){
        if(head==null){
            insertEnd(data);
            return;
        }
        Node node = new Node(data);
        node.next =  head;
        tail.next = node;
        head = node;
    }

    /**
     * Delete a node matching the input value
     * @param data
     */
    public void delete(int data){
        Node node = head;
        if(node==null){
            return;
        }
        if(node.data==data){
            head = head.next;
            tail.next = head;
            return;
        }
        
        do{
            Node n = node.next;
            if(n.data==data){
                node.next = n.next;
                break;
            }
            node = node.next;    
        }
        while(node!=head);

    }

    public void display(){
        Node cur = head;
        do{
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        while(cur!=head);
        System.out.println();
    }
    private class Node{
        private int data;
        private Node next;
        
        public Node(int data){
            this.data=data;            
        }    

    }
}
