public class cycle_questions {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public int cycleLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // Calculate the length
                ListNode temp = slow;
                int length = 0;

                // We need to make temp run at least once. Since temp == slow, use do-while here instead of while
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);

                return length;
            }
        }

        return 0;
    }

    private ListNode createLinkedListWithCycle() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2; // Creating a cycle by connecting the last node to node2

        return head;
    }

    public static void main(String[] args) {
        cycle_questions solution = new cycle_questions();

        // Q 4: Testing hasCycle method
        ListNode head1 = solution.createLinkedListWithCycle();
        boolean hasCycleResult = solution.hasCycle(head1);
        System.out.println("Does the linked list have a cycle? " + hasCycleResult);

        // Q 5: Testing cycleLength method
        ListNode head2 = solution.createLinkedListWithCycle();
        int cycleLengthResult = solution.cycleLength(head2);
        System.out.println("Cycle Length: " + cycleLengthResult);
    }


    // Question 6 -> Linked List Cycle 2

    public ListNode detectCycle(ListNode head) {
        int length = 0;
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) {
                length = cycleLength(slow);
                break; // imp
            }
        }
        
        // edge case
        if(length == 0) {
            return null;
        }
        
        // tricky part
        ListNode f = head;
        ListNode s = head;
        
        while (length > 0) {
            s = s.next;
            length--;
            
        }
        
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }
    
}

