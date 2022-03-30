package LinkedList;

/**
 * https://leetcode.com/problems/reorder-list/
 * Leetcode 143. Reorder List
Medium
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

 */

public class ReorderList {

    public static void main(String args[]){
        ListNode head = new ListNode(1);       
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
       // head.next.next.next.next.next = new ListNode(6);
        display(head);
        System.out.println("After re-ordering:");
        reorderList(head);
        display(head);
    }

    static void display(ListNode head){
        ListNode temp =head;
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp=temp.next;
        }
        System.out.println("End");
    }

    public static void reorderList(ListNode head) {
        ListNode mid = mid(head);
        ListNode secondHead = reverse(mid);
        ListNode firstHead = head;
        while(firstHead!=null && secondHead!=null){
            ListNode temp = firstHead.next;
            firstHead.next =  secondHead;
            firstHead = temp;

            temp = secondHead.next;
            secondHead.next = firstHead;
            secondHead = temp;
        }
        if(firstHead!=null){
            firstHead.next = null;
        }
    }


    public static ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode prev =null;
        ListNode cur = head;
        ListNode next = head.next;
        while(cur!=null){
            cur.next = prev;
            prev = cur;
            cur = next;
            if(next!=null) next = next.next;
        }
        return prev;

    }
}
