 

public class RemoveDuplicate {
    public static void main(String[] args) {
        
        String str = "aaabbbccc";
        StringBuilder newStr = new StringBuilder();
        boolean[] map = new boolean[26]; // Assuming lowercase letters only
        System.out.println(removeDuplicates(str, newStr, 0, map));
    }
   
    static String removeDuplicates(String str,StringBuilder newStr, 
        int idx, boolean[] map) {
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
