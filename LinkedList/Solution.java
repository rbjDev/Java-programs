package LinkedList;

public class Solution {
    public static void main(String args[]){
        //LeetCode -83
        // ListNode head = new ListNode(1);
        // head.next = new ListNode(1);
        // head.next.next = new ListNode(2);
        // head.next.next.next = new ListNode(3);
        // head.next.next.next.next = null;
        // display(head);
        // System.out.println("Linked list afterdeleting duplicates:");
        // head = deleteDuplicates(head);
        // display(head);

        //LeetCode 21
        // ListNode list1 = new ListNode(1);
        // list1.next = new ListNode(2);
        // list1.next.next = new ListNode(2);
        // list1.next.next.next = new ListNode(3);
        // list1.next.next.next.next = null;

        // ListNode list2 = new ListNode(1);
        // list2.next = new ListNode(3);
        // list2.next.next = new ListNode(4);
        // list2.next.next.next = new ListNode(5);
        // list2.next.next.next.next = null;
        // System.out.println("List 1:");
        // display(list1);
        // System.out.println("List 2:");
        // display(list2);
        // ListNode list3 = mergeTwoLists(list1, list2);
        // System.out.println("Merged list: ");
        // display(list3);

        //LeetCode 141
        // ListNode head = new ListNode(3);
        // ListNode cycleNode = new ListNode(2);
        // head.next = cycleNode;
        // head.next.next = new ListNode(4);
        // head.next.next.next = new ListNode(9);
        // head.next.next.next.next = new ListNode(7);
        // head.next.next.next.next.next = cycleNode;
        // System.out.println("Has Cycle:" + hasCycle(head));   
        // System.out.println("Cycle length:" + cycleLength(head));    
        // System.out.println("Detect cycle begin node:" + detectCycle(head)); 

        //MergeSort
        // ListNode head = new ListNode(4);
        // head.next = new ListNode(3);
        // head.next.next = new ListNode(5);
        // head.next.next.next = new ListNode(7);
        // head.next.next.next.next = null;
        // display(head);
        // MergeSort.sortList(head);
        // display(head);

        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = null;
        display(head);
        System.out.println("Is palindrome:" + isPalindrome(head));
        display(head);

        System.out.println("Is Palindrome?:" + isPalindrome("0P"));

    }

    static void display(ListNode head){
        ListNode temp =head;
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp=temp.next;
        }
        System.out.println("End");
    }

    /**
     * LeetCode 83. Remove Duplicates from Sorted List
     * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
       ListNode cur = head;        
        while(cur.next!=null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            else{
                cur = cur.next;
            }
            
        }        
        return head; 
    }

    /**
     * LeetCode 21. Merge Two Sorted Lists
     * https://leetcode.com/problems/merge-two-sorted-lists/
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode firstNode = new ListNode();
        ListNode tail = firstNode;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;                
            }
            else{
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1!=null) ? list1 : list2;
        return firstNode.next;
    }


/**
 * LeetCode 141. Linked List Cycle detection
 * https://leetcode.com/problems/linked-list-cycle/
 * 
 */
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                System.out.println("Slow=fast node value:" + fast.val);
                return true;
            }
        }
        return false;
      
    }

    public static int cycleLength(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                System.out.println("Slow=fast node value:" + fast.val);
                int count=0;
                do{
                    count++;
                    slow = slow.next;
                }
                while(slow!=fast);
                return count;
            }
        }
        return 0;
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int length =0;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                System.out.println("Slow=fast node value:" + fast.val);
                int count=0;
                do{
                    count++;
                    slow = slow.next;
                }
                while(slow!=fast);
                length = count;
                break;
            }
        }
        if(length==0) return null;

        ListNode f = head;
        ListNode s = head;
        while(length>0){
            s=s.next;
            length--;
        }

        while(s!=f){
            s=s.next;
            f=f.next;
        }
        return s;        
    }

    /**
     * LeetCode 206
     * https://leetcode.com/problems/reverse-linked-list/
     */
    public static ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;
        while(present!=null){
            present.next = prev;
            prev = present;
            present = next;
            if(next!=null)
                next= next.next;
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(left==right)
            return head;
        ListNode prev= null;
        ListNode current = head;

        //Skip the first left-1 nodes.
        for(int i=1;i<left;i++){
            prev = current;
            current = current.next;
        }

        ListNode first = prev;
        ListNode newEnd = current;
        ListNode next = current.next;

        //Reverse between left and right
        for(int i=left;current!=null && i<=right;i++){
            prev = current;
            current = current.next;
            if(next!=null){
                next = next.next;
            }       

        }
         if(first!=null){
             first.next = prev;
         }
         else{
             head = prev;
         }

         newEnd.next = current;
         return head;

    }

    public static boolean isPalindrome(ListNode head) {
        ListNode temp =head;
        StringBuilder str= new StringBuilder();
        while(temp!=null){
            str.append(temp.val);
            temp = temp.next;
        }
        return isPalindromeString(str.toString());
    }


    static boolean isPalindromeString(String str)
    {
        int i = 0, j = str.length() - 1;
         while (i < j) {
 
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }


    public static boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        String str = lower.replaceAll("[^a-z0-9]", "");
        int i = 0, j = str.length() - 1;
        if(str.length()==1) return false;
         while (i < j) {
 
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
        
    }

    



}
