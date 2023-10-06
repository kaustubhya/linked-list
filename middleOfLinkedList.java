public class middleOfLinkedList {

 // Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode middleNode(ListNode head) {
        // here we will use simple 2 pointer approach, fast and slow pointer will take care of odd and even so no need to write separate blocks of code for these two
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // slow pointer will give the middle node
        return slow;
    }
}
    
}
