package LinkedList;

public class SinglyLinkedList {
    
    private class Node {
        public int data;
        public Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    Node head;
    
    public SinglyLinkedList(int data) {
        this.head = new Node(data);
    }
    public Node getHead( ) {
        return head;
    }

    public void addFirst(int data) {
        if(isEmpty()) {
            this.head = new Node(data);
        }else {
            Node newNode = new Node(data);
            newNode.next = this.head;
            this.head = newNode;
        }
        
    }


    public void addLast(int data) {
        if(isEmpty()){
            this.head = new Node(data);
        }else {
            Node temp = this.head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }


    public void addAt(int index, int data) {
        Node newNode = new Node(data);
        if (index == 0){
            newNode.next = this.head;
            this.head = newNode;
        }
        
        else if(index > size() - 1){
            throw new IndexOutOfBoundsException();
        }else {
            int currIndex = 0;
            Node temp = this.head;
            Node prev = null;
            while(currIndex < index){
                prev = temp;
                temp = temp.next;
                currIndex++;
            }
            prev.next = newNode;
            newNode.next = temp;
        }
       
    }


    public void removeFirst() {
        this.head = this.head.next;
    }
    

    public void print() {
        Node temp = this.head;
        if(isEmpty())
            System.out.println("List is empty");
        while(temp != null){
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
        System.out.println();
    }
    

    public int size() {
        Node temp = this.head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }
    

    public boolean isEmpty() {
        return (head == null) ? true: false;
    }

    public void removeLast() {
       Node temp = head;
       if(temp.next == null){
            head = null;
       }else {
            Node prev = null;
            while(temp.next != null){
                    prev = temp;
                    temp = temp.next;
            }
            prev.next = temp.next;
       }
       
    }
    
    public void removeAt(int index) {
      if(index == 0){
        removeFirst();
      }else if(index >= size()){
        throw new IndexOutOfBoundsException();
      }else {
        Node temp = head;
        Node prev = null;
        int currentIndex = 0;
        while(index > currentIndex){
            currentIndex++;
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
      }
    }
    
}