package runners;

import LinkedList.SinglyLinkedList;

public class ListRunner {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList(0);
        list.addFirst(1);
        list.addLast(2);
        list.print();
    }
}
