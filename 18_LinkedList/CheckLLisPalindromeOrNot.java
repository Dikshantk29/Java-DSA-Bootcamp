import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CheckLLisPalindromeOrNot {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        System.out.println(isPalindrome(head));   // ArrayList method
        CheckLLisPalindromeOrNot ll = new CheckLLisPalindromeOrNot();
        System.out.println(ll.checkPalindrome(head)); // O(1) space method
    }

    // ================= ArrayList Method =================
    // O(n) time, O(n) space
    public static boolean isPalindrome(Node head) {
        ArrayList<Integer> list = new ArrayList<>();

        Node temp = head;
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // ================= Slow–Fast Method =================
    // O(n) time, O(1) space

    // Step 1: Find mid
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Step 2 & 3: Reverse half and compare
    public boolean checkPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find mid
        Node mid = findMid(head);

        // Reverse second half
        Node prev = null;
        Node curr = mid.next;   // IMPORTANT FIX
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Compare halves
        Node left = head;
        Node right = prev;

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
