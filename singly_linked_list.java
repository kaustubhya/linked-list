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
            size = size = size-1;
        }

        else {
            node = node.next;
        }
    }

    tail = node;
    tail.next = null;
    
}



// Question 3


public static singly_linked_list merge(singly_linked_list first, singly_linked_list second) {
    Node f = first.head;
    Node s = second.head;

    singly_linked_list answerLL = new singly_linked_list();

    while(f != null && s != null) {
        if(f.value < s.value) {
            answerLL.insertLast(f.value);
            f = f.next;
        }

        else {
            answerLL.insertLast(s.value);
            s = s.next;
        }

    }

    // adding the remaining values

    // only one of the 2 while loops will run
    while (f != null) {
        answerLL.insertLast(f.value);
        f = f.next;
    }

     while (s != null) {
        answerLL.insertLast(s.value);
        s = s.next;
    }

    return answerLL;
}


// Q. 9 Bubble Sort LL
public void bubbleSort() {
    bubbleSort(size - 1, 0);
}


public void bubbleSort (int row, int col) {
    // we use recursion here and start row from size - 1 to 0 and column from 0, here first top row is size - 1 and last bottom row is 0

    if(row < 0 || col < 0) { // edge case
        System.out.println("Invalid row or col");
    }

    if(row == 0) {
        return; // base case + void return type
    }

    if(col < row) {
        // elements to be sorted at the beginning of the list

        // get 2 pointers, first and second

        Node first = getValue(col);
        // col is the current index we are at
        Node second = getValue(col + 1);

        Node prev = getValue(col - 1);
        if(first.value > second.value) {
            // beginning of the list
            if(first == head) {
                // swapping 3 cases
                head = second;
                first.next = second.next;
                second.next = first;
            }

            // end of the list
            else if(second == tail) {
                // 4 cases of swap
                

                // be careful of the order -> left to right
                prev.next = second;
                tail = first;
                first.next = null;
                second.next = tail;
            }

            else {
                // in the middle of the list

                prev.next = second;

                // like the beginning of the list
                first.next = second.next;
                second.next = first;
                
            }
            
        }

        // all values sorted, increase column val via recursion
        bubbleSort(row, col + 1);
    }
    // row becomes smaller than column, i.e. end of line reached
    
    // hence move to next row and start from the beginning of the column
    bubbleSort(row - 1, 0);
}



// Q.10 Reversing a Linked List  Using Recursion

private void reverse(Node node) {
    if(node == tail) {
        head = tail;
        return;
        // base case
    }

    reverse(node.next);
    // do it till you reach the tail

    tail.next = node;
    node = tail;
    tail.next = null;
    // these 3 keeps happening recursively till all of list is reversed

}


// Q.11 Reversing a Linked List  Using Iteration (In-Place Sorting of Linked List and Reversing it) 

public void reverse() {
    // using prev, current and next pointers
    // given only head, no tail

    if(size < 2) {
        return;
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

    head = prev;


}

public static void main(String[] args) {
    
    // // Q2
    // singly_linked_list ll = new singly_linked_list();
    // ll.insertLast(1);
    // ll.insertLast(1);
    // ll.insertLast(1);
    // ll.insertLast(2);
    // ll.insertLast(2);
    // ll.insertLast(4);

    // ll.display();
    // ll.duplicateRemoval();
    // ll.display();

    singly_linked_list firstLL = new singly_linked_list();
    singly_linked_list secondLL = new singly_linked_list();

    firstLL.insertLast(1);
    firstLL.insertLast(3);    
    firstLL.insertLast(5);
    firstLL.insertLast(7);


    secondLL.insertLast(1);
    secondLL.insertLast(2);
    secondLL.insertLast(4);
    secondLL.insertLast(6);

    singly_linked_list answer = singly_linked_list.merge(firstLL, secondLL);
    answer.display();



    singly_linked_list list5 = new singly_linked_list();
    for(int i = 7; i > 0; i--) {
        list5.insertLast(i);
    }
    list5.display();
    list5.bubbleSort();
    list5.display();

}


}



 
