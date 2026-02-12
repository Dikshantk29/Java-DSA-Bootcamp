public class mergeLL {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        mergeLL list = new mergeLL();

        Node head = list.new Node(4);
        head.next = list.new Node(2);
        head.next.next = list.new Node(1);
        head.next.next.next = list.new Node(3);

        System.out.println("Original List:");
        list.printList(head);

        head = list.mergeSort(head);

        System.out.println("Sorted List:");
        list.printList(head);

        
    }

    // Merge Sort for Linked List
    public Node mergeSort(Node head) {

        // ✅ Base case
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);

        return merge(left, right);
    }

    // Find middle of linked list
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted linked lists
    private Node merge(Node left, Node right) {
        Node dummy = new Node(0);
        Node curr = dummy;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        curr.next = (left != null) ? left : right;
        return dummy.next;
    }

    // Print linked list
    private void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }



    
}
