
public class Palindrome {
    public static void main(String[] args) {
        String str = "madam";
        boolean value = checkPalindrome(str);
        System.out.println("it's palindrome: " + value);

    }

    public static boolean checkPalindrome(String str) {
        // time complexity O(n) and space complexity O(1)
        for (int i = 0; i <= (str.length()) / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }

        }
        return true;
    }
}
