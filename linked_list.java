public class linked_list {

    private Node head;
    private Node tail;

    private int size;

    public linked_list() {
        this.size = 0;
    }

    public void insertFirst(int val) { 
        // for inserting a new node, first create a new node
        Node node = new Node(val);
      // redirect it to the head
        node.next = head;
        // update the head
        head = node;

        // give the tail condition
        if(tail == null) {
            tail = head;
        }

        size += 1;

    }

    public void insertLast(int val) {
        if(tail == null) {
            insertFirst(val);
            return;
        }
        
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAtGivenIndex(int val, int index) {
        if(index == 0) {
            insertFirst(val);
            return;
        }

        if(index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for(int i = 1; i < index; i++) {
            // here i = 0 is the head node, 
            //and we are going till index - 1, hence used 
            //i < index

            temp = temp.next;
            // after index -1, we go to .next i.e. the new element to be inserted
        }

        // before inserting, create that node
        Node node = new Node(val, temp.next);
        // here let's say we put 7 in the new node, hence this will be the value of temp. Now to continue to the original path, we give the 
        // argument "temp.next" i.e. the next value after 7 say 8

        temp.next = node; // initializing value in this created node
        size++; // lastly, incrementing the size



    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    


private class Node {
    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node (int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
}



 
