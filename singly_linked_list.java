public class singly_linked_list {

    private Node head;
    private Node tail;

    private int size;

    public singly_linked_list() {
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


    public Node getValue(int index) {
        Node node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public Node findNode(int value) {
        Node node = head;
        while(node != null) {
            if(node.value == value) {
                return node;
            }
            node = node.next;
        }
// if no node matches the value
        return null;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = getValue(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if(head == null) {
            tail = null;
        }

        size--;
        return val;
    }

     public int deleteFromAnIndex(int index) {

        
            if(index == 0) {
                return deleteFirst();
            }

            if(index == size - 1) {
                return deleteLast();
            }

            Node previous = getValue(index - 1);
            int val = previous.next.value;

            previous.next = previous.next.next;

            return val;
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



// Q.1.
    // insert using recursion

    public void insertRecursion(int val, int index) {
       head = insertRec(val, index, head); 
    }

    private Node insertRec(int val, int index, Node node) {
        if(index == 0) {
            // Start from beginning
            Node temp = new Node(val, node);
            size++;
            return temp;
            // temp = node here
        }

        node.next = insertRec(val, index - 1, node.next);
        // don't do index-- because you'll get null pointer exception
        return node;
    }

// Question 2
public void duplicateRemoval() {
    Node node = head;

    while(node.next != null) {
        if(node.value == node.next.value){ 
            node.next = node.next.next;
            size = size--;
        }

        else {
            node = node.next;
        }
    }

    tail = node;
    tail.next = null;
    
}

public static void main(String[] args) {
    singly_linked_list ll = new singly_linked_list();
    ll.insertLast(1);
    ll.insertLast(1);
    ll.insertLast(1);
    ll.insertLast(2);
    ll.insertLast(2);
    ll.insertLast(4);

    ll.display();
    ll.duplicateRemoval();
    ll.display();



}
}



 
