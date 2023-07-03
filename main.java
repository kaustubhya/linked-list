import java.util.LinkedList;
public class main {
    public static void main(String[] args) {
    //  LinkedList<Integer> my = new LinkedList<>();
    //  my.add(5);
    //  my.add(2);
    //  System.out.println(my);

    // singly_linked_list list = new singly_linked_list();

    // // Add all these values to the start of the previous one.
    // // Here the first value initially is null then we keep 
    // //adding all these value in the front of it
    // list.insertFirst(7);
    // list.insertFirst(3);
    // list.insertFirst(2);
    // list.insertFirst(8);
    // list.insertFirst(25);

    // list.insertLast(99);
    // list.insertLast(52);

    // list.insertAtGivenIndex(47, 3);

    // list.display();

    // System.out.println(list.deleteFirst());
    // list.display();

    // System.out.println(list.deleteLast());
    // list.display();

    // System.out.println(list.deleteFromAnIndex(2));
    // list.display();
    // }

    doubly_linked_list listTwo = new doubly_linked_list();
    listTwo.insertFirst(45);
    listTwo.insertFirst(10);
    listTwo.insertFirst(123);
    listTwo.insertFirst(8);
    listTwo.insertFirst(4);
    listTwo.display();

    listTwo.insertLast(200);
    listTwo.display();

    listTwo.insertAfterGivenIndex(123, 999);
    listTwo.display();

    listTwo.insertAfterGivenIndex(200, 00);
    listTwo.display();

    } 



}