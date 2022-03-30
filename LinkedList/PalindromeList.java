package LinkedList;
/**234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeList {

    public static void main(String args[]){
        ListNode head = new ListNode(1);       
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        display(head);
        System.out.println("is Palindrome?" + isPalindrome(head));
    }

    static void display(ListNode head){
        ListNode temp =head;
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp=temp.next;
        }
        System.out.println("End");
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode mid =mid(head);
        ListNode reverseHead = reverse(mid);
        ListNode reversHeadCopy = reverseHead;
        while(head!=null && reverseHead!=null){
            if(head.val!=reverseHead.val) break;
            head = head.next;
            reverseHead = reverseHead.next;
        }
        reverse(reversHeadCopy);
        if(head==null) return true;        
        return false;
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
