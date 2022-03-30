package LinkedList;

public class MergeSort {
    public static ListNode sortList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid = getMid(head);
        
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    public static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast =  fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        return mid;
        
    }
    
    public static ListNode merge(ListNode list1, ListNode list2) {
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

}
