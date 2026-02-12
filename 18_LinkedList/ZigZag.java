public class ZigZag {
    public static void main(String[] args) {
        
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        ZigZag ll = new ZigZag();
        ll.zigZag(head);
        ll.printList(head);

    }
    public void zigZag(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find mid
        Node mid = findMid(head);

        // Step 2: Reverse second half
        Node prev = null;
        Node curr = mid.next;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        mid.next = null; // Split the list into two halves

        // Step 3: Merge in zig-zag manner
        Node left = head;
        Node right = prev;

        while (left != null && right != null) {
            Node leftNext = left.next;
            Node rightNext = right.next;

            left.next = right; // Link left to right
            if (leftNext == null) {
                break; // If left is the last node, break
            }
            right.next = leftNext; // Link right to next of left

            left = leftNext; // Move left pointer
            right = rightNext; // Move right pointer
        }
    }

    // Find middle of linked list
    private Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
