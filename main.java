import java.util.LinkedList;
public class main {
    public static void main(String[] args) {
    //  LinkedList<Integer> my = new LinkedList<>();
    //  my.add(5);
    //  my.add(2);
    //  System.out.println(my);

    linked_list list = new linked_list();

    // Add all these values to the start of the previous one.
    // Here the first value initially is null then we keep 
    //adding all these value in the front of it
    list.insertFirst(7);
    list.insertFirst(3);
    list.insertFirst(2);
    list.insertFirst(8);
    list.insertFirst(25);

    list.insertLast(99);
    list.insertLast(52);

    list.insertAtGivenIndex(47, 3);

    list.display();

    System.out.println(list.deleteFirst());
    list.display();

    System.out.println(list.deleteLast());
    list.display();


    }
}