package LinkedList;

public class DoublyLinkedList {
    
    private class DLLNode{
        public int data;
        public DLLNode next;
        public DLLNode prev;
        public DLLNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
    
        }
    }
    DLLNode head;
    public DoublyLinkedList(int data) {
        this.head = new DLLNode(data);
    }
    
    public void addFirst(int data) {
        if(this.head == null) {
            this.head = new DLLNode(data);
        }
        DLLNode newNode = new DLLNode(data);
        this.head.prev = newNode;
        newNode.next = this.head;
        this.head = newNode;
    }

    public void addLast(int data) {
        DLLNode newNode = new DLLNode(data);
        if(isEmpty()){
            this.head = newNode;
        }else {
            DLLNode temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        

    }

    public void addAt(int index, int data) {
        if(index == 0) {
        addFirst(data);
        } else if(index > size()) {
        throw new IndexOutOfBoundsException(); 
        } else {
            int currentIndex = 0;
            DLLNode temp = head;
            while(currentIndex < index) {
                temp = temp.next;
                currentIndex++;
            }
            DLLNode newNode = new DLLNode(data);
            newNode.prev = temp.prev;
            newNode.next = temp;
            temp.prev.next = newNode;
            temp.prev = newNode;
        }
    }

    public void removeFirst() {
        if(isEmpty()){
            print();
        } else if(size() == 1){
            this.head = null;
        } else {
            head = head.next;
            head.prev = null;       
        }
    }

    public void removeLast() {
        if(isEmpty()) {
            print();
        }else if( size() == 1){
            this.head = null;
        }else {
            DLLNode temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
            temp.prev = null;
        }
    }

    public void removeAt(int index) {
        if(isEmpty()){
            print();
        }else if(index == 0) {
            removeFirst();
        } else if(index > size()) {
        throw new IndexOutOfBoundsException(); 
        } else {
            int currentIndex = 0;
            DLLNode temp = head;
            while(currentIndex < index) {
                temp = temp.next;
                currentIndex++;
            }
            temp.prev.next = temp.next;
            if(temp.next != null) {
                temp.next.prev = temp.prev;
            } 
            temp.prev = null;
        }
    }

    public void print() {
        if(isEmpty()){
            System.out.println("List is empty...");
        }else {
            DLLNode temp = head;
            while(temp != null) {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
        }
        System.out.println();
    }

    public int size() {
        DLLNode temp = head;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public boolean isEmpty() {
        return (head == null) ? true : false;
    }
    
    
    
    public static void main(String args[]) {
        DoublyLinkedList list = new DoublyLinkedList(1);
        list.print();
        list.addFirst(0);
        list.print();
    }
}