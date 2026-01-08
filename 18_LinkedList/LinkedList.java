public class LinkedList {

    /* =======================
       Node class (Inner Class)
       ======================= */
    class Node {
        int data;      // value stored in node
        Node next;     // reference to next node

        // constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /* =======================
       LinkedList properties
       ======================= */
    public static Node head;   // first node
    public static Node tail;   // last node
    public static int size;    // total number of nodes

    /* =======================
       Add at beginning
       ======================= */
    public void addFirst(int data) {

        // 1. Create new node
        Node newNode = new Node(data);
        size++;

        // 2. If LinkedList is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // 3. Point new node to current head
        newNode.next = head;

        // 4. Update head
        head = newNode;
    }

    /* =======================
       Add at end
       ======================= */
    public void addLast(int data) {

        // 1. Create new node
        Node newNode = new Node(data);
        size++;

        // 2. If LinkedList is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // 3. Link last node to new node
        tail.next = newNode;

        // 4. Update tail
        tail = newNode;
    }

    /* =======================
       Print LinkedList
       ======================= */
    public void print() {

        // Check if list is empty
        if (head == null) {
            System.out.println("ll is empty");
        }

        // Temporary node for traversal
        Node temp = head;

        // Traverse till end
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        // End of list
        System.out.println("null");
    }

    /* =======================
       Add at specific index
       ======================= */
    public void add(int idx, int data) {

        // If index is 0, add at beginning
        if (idx == 0) {
            addFirst(data);
            return;
        }

        // Create new node
        Node newNode = new Node(data);
        size++;

        // Traverse to node before index
        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        // temp now points to previous node

        // Insert new node
        newNode.next = temp.next;
        temp.next = newNode;
    }

    /* =======================
       Remove first element
       ======================= */
    public int removeFirst() {

        // Case 1: Empty list
        if (size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }

        // Case 2: Only one element
        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // Case 3: More than one element
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    /* =======================
       Remove last element
       ======================= */
    public int removeLast() {

        // Case 1: Empty list
        if (size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }

        // Case 2: Only one element
        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // Case 3: More than one element
        // Find second last node
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        // Remove last node
        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;

        return val;
    }

    /* =======================
       Iterative search
       ======================= */
    public int iteratorSearch(int key) {

        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        // Key not found
        return -1;
    }

    /* =======================
       Recursive search helper
       ======================= */
    public int helper(Node head, int key) {

        // Base case: end of list
        if (head == null) {
            return -1;
        }

        // Key found
        if (head.data == key) {
            return 0;
        }

        // Recursive call
        int idx = helper(head.next, key);

        // If not found in remaining list
        if (idx == -1) {
            return -1;
        }

        // Add 1 while returning
        return idx + 1;
    }

    /* =======================
       Recursive search
       ======================= */
    public int recursivesearch(int key) {
        return helper(head, key);
    }

    /* =======================
       Main method
       ======================= */
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        // Initially empty
        ll.print();

        // Add elements at beginning
        ll.addFirst(3);
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();

        // Add elements at end
        ll.addLast(4);
        ll.print();
        ll.addLast(5);
        ll.print();
        ll.addLast(6);
        ll.print();

        // Add at index
        ll.add(0, 0);
        ll.print();

        // Print size
        System.out.println("Size: " + size);

        // Remove first
        ll.removeFirst();
        ll.print();
        System.out.println("Size: " + size);

        // Remove last
        ll.removeLast();
        ll.print();
        System.out.println("Size: " + size);

        // Iterative search
        System.out.println(ll.iteratorSearch(10));
        System.out.println(ll.iteratorSearch(4));

        // Recursive search
        System.out.println(ll.recursivesearch(10));
        System.out.println(ll.recursivesearch(4));
    }
}
