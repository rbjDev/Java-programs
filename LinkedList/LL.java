package LinkedList;
/**
 * Custom singly-linked list implementation
 * DSA bootcamp by Kunal Kushwaha
 * https://www.youtube.com/watch?v=58YbpRDc4yw&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=44
 */
public class LL {

    private class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;            
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size = 0;
    }

    public void insertFirst(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
        if(tail==null){
            tail = head;
        }
        size++;
    }

    public void insertEnd(int data){
        Node node = new Node(data);
        if(tail==null){
            insertFirst(data);
            return;
        }
        tail.next =node;
        tail = node;
        size++;
    }

    public void insert(int data, int index){
        if(index==0){
            insertFirst(data);
            return;
        }
        if(index>=size-1){
            insertEnd(data);
            return;
        }
        Node temp = head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        Node node = new Node(data);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public int deleteFirst(){
        if(head==null)
         return -1;
        int data = head.data;
        head=head.next;
        if(head==null){
            tail = null;
        }
           
        size--;
        return data;
    }

    public int deleteLast(){
        if(size<=1){
            return deleteFirst();            
        }
        Node secondLast = get(size-2);
        int data = tail.data;
        secondLast.next = null;
        tail=secondLast;
        size--;
        return data;
    }

    public int delete(int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
        Node prev = get(index-1);
        int data = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return data;
    }

    public Node get(int index){
        Node cur= head;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur;
    }

    public void display(){
        Node temp = head;
        while(temp!=null){            
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.println("End");
    }

    public void insertRecursive(int index, int data){
        head = insertRecursive(index, data, head);        
    }

    public Node insertRecursive(int index, int data, Node cur){
        if(index==0 || cur == null){
            Node temp =  new Node(data);
            temp.next =  cur;
            size++;
            return temp;
        }
        cur.next = insertRecursive(index-1, data, cur.next);
        return cur;
    }


    
    
    
    
}
