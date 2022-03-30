package LinkedList;

public class LeetCode83 {
    private class ListNode{
        int data;
        ListNode next;

        public ListNode(int data){
            this.data = data;            
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public LeetCode83(){
        this.size = 0;
    }

    public void insertFirst(int data){
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
        if(tail==null){
            tail = head;
        }
        size++;
    }
    /** 2-pointer approach */
    public ListNode deleteDuplicatesUsingTwoPointers(ListNode head) {
        ListNode cur = head;
        ListNode temp = head;
        while(temp!=null){
            if(temp.next!=null &&  cur.data!=temp.next.data){
                cur.next = temp.next;
                cur = temp.next;
            }
            temp = temp.next;
        }
        cur.next = temp;
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;        
        while(cur.next!=null){
            if(cur.data == cur.next.data){
                cur.next = cur.next.next;
            }
            else{
                cur = cur.next;
            }
            
        }        
        return head;
    }

    public void deleteDuplicates(){
        head = deleteDuplicates(head);
    }

    public void display(){
        ListNode temp = head;
        while(temp!=null){            
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.println("End");
    }
    public static void main(String args[]){
        LeetCode83 list = new LeetCode83();
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(2);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertFirst(1);
        list.insertFirst(1);                 
        list.display();
        list.deleteDuplicates();
        list.display();
    }


}
