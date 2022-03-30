package LinkedList;
/**
 * https://leetcode.com/problems/rotate-list/
 * 61. Rotate List
Medium

Given the head of a linked list, rotate the list to the right by k places.


 */
public class RotateList {

    public static void main(String args[]){
        ListNode head = new ListNode(1);       
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
       // head.next.next.next.next.next = new ListNode(6);
        display(head);
        System.out.println("After rotating :");
        
        display(rotateRight(head,2));
    }

    static void display(ListNode head){
        ListNode temp =head;
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp=temp.next;
        }
        System.out.println("End");
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null || head.next ==null){
            return head;
        }
        ListNode last = head;
        int length = 1;
        while(last.next!=null){
            last=last.next;
            length++;
        }
        last.next= head;

        int rotations = k%length;
        int skip = length - rotations; 
        ListNode tail = head;
        for(int i = 0; i< skip - 1; i++){
            tail =tail.next;
        }
        head =tail.next;
        tail.next = null;
        
        return head;
    }
}
