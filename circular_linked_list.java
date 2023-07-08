public class circular_linked_list {

    private Node head;
    private Node tail;


    public circular_linked_list() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display() {
        Node node = head;
        if(head != null) {
            do {
                System.out.print(node.val + " -> ");
                node = node.next;

            } while(node != head);
        }
        System.out.println("HEAD");
    }

    public void deleteNode(int val) {
        Node node = head;
        if(node == null) {
            return;
        }

        // Delete the first node i.e. head itself
        if(node.val == val) {
            head = head.next;
            tail.next = head;
            return;
        }

        // Else if we have to delete any other node in that circular list
        do {
            Node n = node.next;
            // n is the next value after head
            if (n.val == val) {
                node.next = n.next;
                // node was still head here in the first iteration here before the above line of code
                break;
            }
            node = node.next;
            // if value is mismatched, move ahead
        } while(node != head);


    }


    private class Node {
        int val;
        Node next;

        //Constructor
        public Node(int val) {
            this.val = val; 
        }
    }
     
}
