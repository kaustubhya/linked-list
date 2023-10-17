public class reverse_Alternate_Nodes_In_A_LL {
  

    /*node class of the linked list */
    class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    
        public static void rearrange(Node odd)
        {
            // add your code here
            if(odd == null || odd.next == null) {
                return;
            }
            
            Node even = odd.next; // first even node
            Node currentOdd = odd;
            Node currentEven = even;
            
            while(currentEven != null && currentEven.next != null) {
                currentOdd.next = currentEven.next;
                currentOdd = currentOdd.next;
                // odd goes 1,3,5,7,.....
                
                if(currentOdd != null && currentOdd.next != null) { // edge case
                    // now even
                    currentEven.next = currentOdd.next;
                    currentEven = currentEven.next;
                    // even goes 2,4,6,8,10,.....
                }
                
                else {
                    currentEven.next = null;
                    break;
                }
                
                
            
            }
            
            
            // once you have joinrd all odds and evens
            
            // reverse all evens, starting from the first even pointer i.e. even
            
            even = reverseLL(even);
            
            // then append all reversed evens to the end of all odds
            currentOdd.next = even;
        }
        
        private static Node reverseLL(Node head) {
            if(head == null) {
                return head;
            }
            Node prev = null;
            Node current = head;
            Node next = current.next;
            
            while(current != null) {
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
