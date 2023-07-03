public class doubly_linked_list {
   
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
