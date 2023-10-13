public class linked_list_reversal_2 {
    
//   Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) {
            return head;
            
//             no need to reverse list here
        }
        
        // We will do 3 steps
        
        // 1. Go from 0 to left - 1
        
//         use five pointers apart from left and right
//         three for reversal 
//         two for step 3 i.e. non reversal
        ListNode prev = null;
        ListNode current = head;
//         these are the first two reversal pointers
        
        for(int i = 0; current != null && i < left - 1; i++) {
            // here we actually wanted to go to left - 1 but since i starts from 0, we will go till left - 2, we will put previous there and put current at left - 1 
            prev = current;
            current = current.next;
        }
        
        // 2. Reversing the sectioned list
        ListNode last = prev;
        ListNode newEnd = current;
//         These are the non reversing pointers
//         Now to get the no. of nodes to reverse, we will use: (right - left + 1)
        
        ListNode next = current.next;
        // third reversal pointer
        
        for(int i = 0; current != null && i < right - left + 1; i++) {
            // current != null - Avoiding null pointer exception

            current.next = prev;
            prev = current;
            current = next;
            
            if(next != null) {
                next = next.next;
            }
        }
        
        // 3. Attaching the non reversing node pointers wrt the reversed list and pointers
        
        if(last != null) {
            last.next = prev;
        }
        else {
            head = prev;
        }
        
        newEnd.next = current;
        
        return head;
        
    }

}
