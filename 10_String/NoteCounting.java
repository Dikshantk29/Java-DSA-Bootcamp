public class NoteCounting {
    public static void main(String[] args) {
        String notes = "AAABBBCCDAA";
        //print A3B3C2D1A2
        countNotes(notes);
        System.out.println();
        countNotes2(notes);
    }
    //complexity O(n) and space O(1)
    static void countNotes(String notes) {
        int count = 1;
        for (int i = 1; i <= notes.length(); i++){
            if (i == notes.length() || notes.charAt(i) != notes.charAt(i - 1)) {
                System.out.print(notes.charAt(i - 1));
                System.out.print(count);
                count = 1;
            } else {
                count++;
            }
        }
    }

    //using stringbuilder
    //complexity O(n) and space O(n)
    static void countNotes2(String notes) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= notes.length(); i++) {
            if (i == notes.length() || notes.charAt(i) != notes.charAt(i - 1)) {
                sb.append(notes.charAt(i - 1));
                sb.append(count);
                count = 1;
            } else {
                count++;
            }
        }
        System.out.println(sb);
    }
}