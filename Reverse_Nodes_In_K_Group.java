public class Reverse_Nodes_In_K_Group {

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
  

    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(k <= 1 || head == null) {
            return head;
        }
        
        // This is somewhat same to Linked List cycle 2, but here we will skip step 1 as per the question
        
        // However we need to make some changes for those node groups that are less than k
        
        // a. So Let us find the length of the linked list
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        
        
        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.next;
        
        while(count >= k) {
            ListNode last = prev;
            ListNode newEnd = current;
            
            // Step 2
            
            for(int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                
                if(next != null) {
                    next = next.next;
                }   
                
            }
            
            // Step 3
            
            if(last != null) {
                last.next = prev;
            }
            else{ 
            // here this case will happen
                head = prev;
            }
            
            newEnd.next = current;
            
            
            // coming out of the while loop
            if(current == null) {
                break;
            }
            
            // to move to the next set of k nodes, reposition the prev node
            prev = newEnd;
            
            // reduce count by k each time, till it reaches k, once it is less than k, it will stop reversing those nodes that are less than k
            count = count - k;
        }
        return head;
    }

}

// TC = O(n)
// SC = O(1)

