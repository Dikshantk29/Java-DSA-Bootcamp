
import java.util.Deque;
import java.util.LinkedList;
public class Deque_Concepts {
    //deque - double ended queue
    public static void main(String[] args) {
      Deque<Integer> deque = new LinkedList<>();
        //add - addFirst() and addLast()
        deque.addFirst(1);
        deque.addLast(2);
        System.out.println(deque); // [1, 2]

        //remove - removeFirst() and removeLast()
        deque.removeFirst();
        System.out.println(deque); // [2]
        deque.removeLast();
        System.out.println(deque); // []

        //peek - peekFirst() and peekLast()
        deque.addFirst(1);
        deque.addLast(2);
        System.out.println(deque.peekFirst()); // 1
        System.out.println(deque.peekLast()); // 2

        
    }
    
}
