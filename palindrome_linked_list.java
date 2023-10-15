public class palindrome_linked_list {
    
    // Follow the following steps:
    // 1. Find the middle of the linked list (use findMiddleNode function)
    // Reverse it from middle till the end (use LinkedListReversal Function)
    // Compare the first half (0 to mid - 1) with the second half (mid to end)
    // Re-Reverse the second half

    
//  Definition for singly-linked list.
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
 

    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMidNode(head);
        ListNode head2 = reverseLL(mid);
//         here mid went to the end and head2 came in the middle
        
        ListNode temp = head2;
//         storing this head2 value in a temp which we will use later during LL re-reversal
//         We can't use normal 2 pointer approach here as we can't go backwards and forwards at the same time 
        
        
        // compare both halves 
        while(head != null && head2 != null) {
            if(head.val != head2.val) {
                break;
                // donot return false here as we need to re-reverse the list after this
            }
            head = head.next;
            head2 = head2.next;
//             keep doing this till we reach null for both head and head2
            
        }
        
        // re-reversing the LL
            reverseLL(temp);
//         here temp (i.e. original head2) which was in the middle, now again went to the end and mid came back to middle again
        
        if(head == null || head2 == null) {
            return true;
//             we successfully reached the end without any break which means our list is a palindrome LL
        }
        
        return false;
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

// TC = O(n)
// SC = O(1)
