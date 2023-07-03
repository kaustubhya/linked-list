public class doubly_linked_list {
   
    // Insert First Node
    private Node head;
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;

        if(head != null) {
            head.prev = node;
        }

        head = node;
 
    }

    public void display() {
        Node temp = head;
        Node last = null;
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            last = temp;
            temp = temp.next; 

        }
        System.out.println("END");

        System.out.println("PRINTING IN REVERSE");
        while(last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }
     

    // Insert Last Node
    public void insertLast(int val) {
        Node node = new Node(val);
        Node last = head;
        node.next = null;

        // edge cases
        if(head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }
         
        last.next = node;
        node.prev = last;
    }


    // Insert Node at given Index

    public Node findIndex(int value) {
        Node node = head;
        while(node != null) {
            if(node.val == value) {
                return node;
            }
            node = node.next;
        }

        return null;
    }

    public void insertAfterGivenIndex(int after, int val) {
        Node prev = findIndex(after); // after is the value of prev node

        if (prev == null) {
            System.out.println("Does NOt Exist");
            return;
        }

        Node node = new Node(val);
        node.next = prev.next;
        prev.next = node;
        node.prev = prev;

        if(node.next != null) {
            node.next.prev = node;
        } 
    }


    private class Node {
      private int val;
      private Node next;
      private Node prev;


        // only one node
        public Node (int val) {
            this.val = val;
        }

        // linked list of nodes
        public Node (int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
