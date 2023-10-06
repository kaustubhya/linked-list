public class mergeSortLL {
  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode sortList(ListNode head) {
        // let's use merge sort here
        
        // 1. Base case
        if(head == null || head.next == null) {
            return head; // list already sorted
        }
        
        // 2. finding the middle node
        ListNode middle = findMiddle(head);
        
        // 3. split the list from the middle
        ListNode nextToMiddle = middle.next;
        middle.next = null;
        
        // 4. Sort 2 lists recursively
        ListNode left = sortList(head);
        ListNode right = sortList(nextToMiddle);
        
        
        // 5. Merge the 2 half lists and return it
         return merge(left, right);
        
        
        
    }
    
    private ListNode findMiddle(ListNode head) {
        // a. fast-slow pointers
        ListNode fast = head;
        ListNode slow = head;
        
        // b. add a previous pointer
        ListNode previous = null;
        
        // c. normal conditions
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            previous = slow;

            slow = slow.next;
        }
        
        return previous;
        // split from 0 to mid and mid + 1 to null end
    }
    
  
    private ListNode merge(ListNode left, ListNode right) {
        
        // a. make a new dummy node and a scratch pad node
        ListNode dummy = new ListNode(0);
        ListNode scratchPad = dummy;
        
        // b. normal appending
        while(left!= null && right != null) {
            // exception, compare the values here
            if(left.val < right.val) {
               // add smaller value
                scratchPad.next = left;
                left = left.next;
            }
            
            else {
                scratchPad.next = right;
                right = right.next;
            }
            
            // c. move to a fresh scratchPad node
            scratchPad = scratchPad.next;
            
        }
        
        // d. if left or right nodes are unequal, take care of them
        
        if(left != null) {
            // it is still not done
            scratchPad.next = left;
        }
        
        if(right != null) {
            scratchPad.next = right;
        }
        
       /* e. finally return the dummy node, 
        don't return the 0th value as it is empty, return from the next value */
        
        return dummy.next;
        
    }
}
}
