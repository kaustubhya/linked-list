public class reorder_linked_list {
    
    //  Definition for singly-linked list.
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    
        public void reorderList(ListNode head) {
            // we will use 
          /*  1. Middle node of linked list
            2. Reversing the list from node + 1 
            3. Finally using 4 pointers, head1 and head2 & temp1 and temp2 */
            
            // edge case 
            if(head == null || head.next == null) {
                return;
            }
            
            ListNode head1 = head;
            ListNode mid = findMidNode(head);
            ListNode head2 = reverseLL(mid);
            
            // Since we will move head1 and head2, we will store the nodes next to them in temp1 and temp2
            
        // ****     Don't initialize here as we are getting TLE, initialize inside the loop
            ListNode temp1;
            ListNode temp2;
            
            while(head1 != null && head2 != null) {
                // Assuming we have head1 node already in place
                temp1 = head1.next;
                temp2 = head2.next;
                
                head1.next = head2;
                head1 = temp1;
                head2.next = temp1;
                head2 = temp2;
            }
            
    //         if there is any end node left, in case of ODD nodes, take care of them
            if(head1 != null) {
                head1.next = null;
            } // here this node would be probably in the middle which will go to the last position, just before null, after reordering
            
        }
        
        
        
        
        
        //     Supporting methods
    //     1. Finding middle node of LL
        private ListNode findMidNode(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            
            while(fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
        
        // 2. Reversing LL
        private ListNode reverseLL(ListNode head) {
            ListNode prev = null;
            ListNode current = head;
            ListNode next = current.next;
            
            
            while (current != null) {
                current.next = prev;
                prev = current;
                current = next;
                
                if(next != null) {
                    next = next.next;
                }
            }
            
            return prev;
    
        }

}
