
public class FindSubSet {
    public static void main(String[] args) {
        String str = "abc";
        findSubSet(str, "", 0);

    }

    public static void findSubSet(String str, String ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            }
            System.out.println(ans);
            return;
        }

        // recusrison

        // yes choice
        findSubSet(str, ans + str.charAt(i), i + 1);
        // no choice
        findSubSet(str, ans, i + 1);
    }
}
