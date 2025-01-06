public class StackusingQueue {
    static class Node {
        int data;
        Node next;
    }
    static Node front = null, rear = null, n1, n2;
    // Function to enqueue an element into the queue
    static void enqueue(int num) {
        n1 = new Node();
        n1.data = num;
        n1.next = null;
        if (front == null)
            front = rear = n1;
        else {
            rear.next = n1;
            rear = n1;
        }
    }
    static int dequeue() {
        Node temp;
        if (front == null) {
            System.out.println("Queue Is Empty!");
            return -999;
        }
        int value = front.data;
        temp = front;
        front = front.next;
        return value;
    }
    // pushing elements into the stack
    static void push(int num) {
        enqueue(num);
        n2 = new Node();
        n2.data = num;
        n2.next = null;
    }
    static void pop (){
        Node temp = null;
        while (front != null) {
            int value = dequeue();
            if (temp == null) {
                temp = n2;
            }
            else {
                temp.next = new Node();
                temp = temp.next;
            }
            temp.data = value;
        }
    }
    // Function to display the elements of the stack
    static void display() {
        for (Node temp = n2; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
    }
    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);
        push(40);
        push(50);

        pop ();
        pop ();
        display();
    }
}
