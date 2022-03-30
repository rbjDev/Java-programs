package LinkedList;
/**
 * Custom doubly-linked list implementation
 * DSA bootcamp by Kunal Kushwaha
 * https://www.youtube.com/watch?v=58YbpRDc4yw&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=44
 */
public class DLL {
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        private int data;
        private Node prev;
        private Node next;
        
        public Node(int data){
            this.data=data;            
        }    

    }

    public DLL(){
        size=0;        
    }

    public void addFirst(int data){
        Node node = new Node(data);
        if(head==null){
            head = node;
            tail = node;
        }
        else{
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addLast(int data){
        if(size==0){
            addFirst(data);
            return;
        }
        Node node = new Node(data);
        node.prev = tail;
        tail.next = node;
        tail = node;
        size++;
    }

    public void add(int data, int index){
        if(index==0){
            addFirst(data);
            return;
        }
        if(index>=size-1){
            addLast(data);
            return;
        }
        Node node = new Node(data);
        Node prev = get(index-1);
        node.next = prev.next;
        prev.next.prev = node;
        node.prev = prev;
        prev.next = node;
        size++;


    }

    public Node get(int index){
        Node cur = head;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur;
    }

    public int size(){
        return size;
    }

    public void display(){
        Node cur = head;
        while(cur!=null){
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.print("End");
        System.out.println();
    }

    public void displayReverse(){
        Node cur = tail;
        while(cur!=null){
            System.out.print(cur.data + " -> ");
            cur = cur.prev;
        }
        System.out.print("Start");
        System.out.println();

    }
}
