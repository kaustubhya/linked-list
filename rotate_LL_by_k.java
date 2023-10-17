public class rotate_LL_by_k {   

     // Definition for singly-linked list.
     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { 
           this.val = val; 
       }
        ListNode(int val, ListNode next) { 
           this.val = val; 
           this.next = next; 
       }
    }
 

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k <= 0) {
            return head;
        }
        
        
        // let us find the linked list length which will help us reduce k rotations if k is more than length of ll
        
        ListNode last = head;
        int count = 1;
        while(last.next != null) {
            last = last.next;
            count++;
            
        }
        
        
        int rotate = k % count; // imp
           //  eg. length 5, k 7, then instead of rotating 7 times, just rotate 5 times
        if(rotate == 0) {
            return head;
        }
        
        
        int skip = count - rotate; // if length = 5, k = 2, then skip by 5 - 2 = 3
        
        
        ListNode newLast = head;
        
       for(int i = 0; i < skip - 1; i++) {
           newLast = newLast.next;
           // starts from head, goes till length - k i.e. (skip) nodes ahead
           // we did skip - 1 because we now it will reach skip with the .next method
       }
        
        ListNode newHead = newLast.next;
        newLast.next = null;
        last.next = head;
        
        return newHead;
        
    }
    
}



