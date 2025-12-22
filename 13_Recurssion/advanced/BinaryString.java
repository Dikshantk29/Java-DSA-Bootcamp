class BinaryString{
    public static void main(String[] args) {
        int n = 3; // Length of binary strings
        generateBinaryStrings(n, "", 0);
    }

    static void generateBinaryStrings(int n, String str, int count) {
        // Base case: if the length of the string is equal to n
        if (str.length() == n) {
            System.out.println(str);
            return;
        }

        // Add '0' and recurse
        generateBinaryStrings(n, str + "0", count);

        // Add '1' and recurse
        generateBinaryStrings(n, str + "1", count + 1);
    }
}