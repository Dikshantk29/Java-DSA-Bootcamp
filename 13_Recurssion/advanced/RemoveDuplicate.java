 

public class RemoveDuplicate {
    public static void main(String[] args) {
        
        String str = "aaabbbccc";
        StringBuilder newStr = new StringBuilder();
        boolean[] map = new boolean[26]; // Assuming lowercase letters only
        System.out.println(removeDuplicates(str, newStr, 0, map));
    }
    // This function removes duplicate characters from a string using recursion.

    // It uses a helper function to keep track of the current index and the result string.

    // The time complexity is O(n^2) because for each character, it checks if it is already in the result string.

    // The space complexity is O(n) for the result string.
    static String removeDuplicates(String str,StringBuilder newStr, int idx, boolean[] map) {
        if (idx == str.length()) {
            return newStr.toString();
        }
        char currChar = str.charAt(idx);
        if (map[currChar - 'a']) {
            return removeDuplicates(str, newStr, idx + 1, map);
        } else {
            map[currChar - 'a'] = true;
            newStr.append(currChar);
        }
        return removeDuplicates(str, newStr, idx + 1, map);
    }
}
