package stack;

public class Stack {

    int array[];
    int top = -1;
    
    public Stack(int stackSize) {
        this.array = new int[stackSize];
    }

    public void push(int data) {
        if(top < array.length-1) {
            array[++top] = data;
        }else {
            throw new StackOverflowError("Stack is full...");
        }
    }

    //remove top element from the stack.
    public int pop() {
        if(top < 0){
            throw new StackOverflowError("Stack is empty...");
        }
        return array[top--];
    }

    // returns the value of top element without removing it.
    public int peek() {
        return array[top];
    }

    public boolean isEmpty() {
        if(top < 0) {
            return false;
        }
        return true;
    }

    public boolean isFull() {
        if(top == array.length - 1) {
            return true;
        }
        return false;
    }


    public void print() {
        for(int i = top; i >= 0; i--) {
            System.out.println("| "+array[i]+ " |");
            System.out.println("-----");
        }
        System.out.println();
    }

}
