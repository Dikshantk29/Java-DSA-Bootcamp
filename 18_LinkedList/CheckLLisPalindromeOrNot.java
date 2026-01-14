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

        System.out.println(isPalindrome(head));
    }

    // o(n) o(n) time and space.
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

    /*
     * ======================= Slow - Fast and Half Reverse =======================
     */
    // step -1
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // step-2

}
