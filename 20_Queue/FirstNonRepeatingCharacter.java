import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "aabbccdeeff";

        // Brute force approach
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (freq[ch - 'a'] == 1) {
                System.out.println("First non-repeating character is: " + ch);
                break;
            }
        }

        //calling queue approach
        firstNonRepeatingCharacter(str);
    }

    // Queue approach
    public static void firstNonRepeatingCharacter(String str) {
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
            q.add(ch);
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }
        }
        if (!q.isEmpty()) {
            System.out.println("First non-repeating character is: " + q.peek());
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
