public class Reverse_Alternate_K_Nodes {
    //  Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseAlternateKNodes(ListNode head, int k) {
        if(head == null || k <= 1) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.next;
        boolean reverse = true;

        while(current != null) {
            ListNode last = prev;
            ListNode newEnd = current;
            // a new pointer
            ListNode prevGroupEnd = last;
            int count = 0;

            // Traverse K nodes
            while(count < k && current != null) {
                current.next = prev;
                prev = current;
                current = next;
                
                if(next != null) {
                    next = next.next;
                }

                count++;
            }

            // game changes from here
            // Connecting the reversed group from the previous group or the head
            if(reverse == true) {
                if(last != null) {
                    last.next = prev;
                }
                else {
                    head = prev;
                }
                newEnd.next = current;
            }
            else {
                // reverse is false here
                if(prevGroupEnd != null) {
                    prevGroupEnd.next = prev;
                }
                newEnd.next = current;
            }

            reverse = !reverse; // imp
            // for the 2nd iteration we will not reverse now
            // The reverse keeps changing between true and false here
            // true means reverse, false means don't reverse


        }

        return head;
    }
 
      
}
