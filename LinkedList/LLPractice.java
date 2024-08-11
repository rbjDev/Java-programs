package LinkedList;

import org.w3c.dom.NodeList;

public class LLPractice {
    static class Node{
        int data;
        Node next;        
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        public Node(){}
        
    }

    static class ListNode{
        int val;
        ListNode next;        
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        public ListNode(){}
        
    }
    static Node createList(int arr[]){
        Node head =null, temp, cur = null;
        for(int i=0;i<arr.length;i++){
            temp = new Node(arr[i], null);
            if(head==null) {
                head = temp;
                cur = temp;
            }
            else{
                cur.next = temp;
                cur = cur.next;
            }
        }
        return head;
    }

    static ListNode createList2(int arr[]){
        ListNode head =null, temp, cur = null;
        for(int i=0;i<arr.length;i++){
            temp = new ListNode(arr[i], null);
            if(head==null) {
                head = temp;
                cur = temp;
            }
            else{
                cur.next = temp;
                cur = cur.next;
            }
        }
        return head;
    }

    static void display(Node head){
        Node temp = head;
        System.out.println("\nPrinting linked list!!");
        while(temp!=null){
            System.out.print(temp.data + " -> ");
            temp=temp.next;
        }
    }

    static void display2(ListNode head){
        ListNode temp = head;
        System.out.println("\nPrinting linked list!!");
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp=temp.next;
        }
    }

    static Node mergeLists(Node list1, Node list2){
        Node head = new Node(); 
        Node cur = head;
        while(list1!=null && list2!=null){
            if(list1.data <= list2.data){
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }
            else{
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        cur.next = list1!=null ? list1 : list2 ;
        return head.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        int carry = 0;
        while(l1!=null || l2!=null ||carry==1){
            int sum = 0;
            if(l1!=null){
                sum+= l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum+= l2.val;
                l2 = l2.next;
            }
            sum+= carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10,null);
            temp.next = node;
            temp = temp.next;

        }
        return head.next;
    }

    void addToFirst(ListNode head, int val){
        ListNode temp = new ListNode(val,null);
        if(head==null) head = temp;
        else {
            temp.next = head;
            head = temp;
        } 
    }

    public ListNode partition(ListNode[] lists, int start, int end){
        if(start==end)  return lists[start];
        if(start < end){
            int mid = start + (end-start)/2 ; 
            ListNode l1 = partition(lists , start, mid);
            ListNode l2 = partition(lists, mid+1, end);
            return merge(l1, l2);
        }
        return null;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        if(l1==null)    return l2;
        if(l2==null)    return l1;
        if(l1.val <= l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else{
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        // Node list1 = createList(new int[]{2,4,7,9});
        // Node list2 = createList(new int[]{1,6,8,19,25});
        // display(list1);
        // display(list2);
        // display(mergeLists(list1, list2));

        ListNode list1 = createList2(new int[]{2,4,7,9});
        ListNode list2 = createList2(new int[]{1,6,8,19,25});
        display2(list1);
        display2(list2);
    }
}
