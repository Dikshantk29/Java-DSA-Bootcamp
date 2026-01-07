
public class LinkedList {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    // methods

    public void addFirst(int data) {
        // 1.create new node
        Node newNode = new Node(data);

        // assume my ll is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // 2.newNode next = head
        newNode.next = head;

        // 3.head = newNode
        head = newNode;

    }

    public void addLast(int data) {
        // 1.create new Node
        Node newNode = new Node(data);

        // assume LinkedList is empty
        if (head == null) {
            head = tail = newNode;
            return;

        }

        // 2.tail.next = newNode
        tail.next = newNode;

        // 3.tail = newNode
        tail = newNode;
    }

    public void print() {
        if (head == null) {
            System.out.println("ll is empty");
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data) {


        if(idx ==0){
           addFirst(data);
           return; 
        }
        Node newNode = new Node(data);

        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        //i =idx-1 and temp = prev

        newNode.next = temp.next;
        temp.next =newNode;

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        ll.print();

        ll.addFirst(3);
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();

        ll.addLast(4);
        ll.print();
        ll.addLast(5);
        ll.print();
        ll.addLast(6);
        ll.print();


        ll.add(0, 0);
        ll.print();

    }
}
