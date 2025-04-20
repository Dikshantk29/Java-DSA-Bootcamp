class PrintDsc {
    public static void main(String[] args) {

        printNumberInDsc(5);
        System.out.println();
        printNumberInAsc(1);
    }
    
    
//decreasing order
    static void printNumberInDsc(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        printNumberInDsc(n - 1);
    }

//increasing order
    static void printNumberInAsc(int n) {
        if (n == 6) { // 5+1 = 6
            return;
        }
        System.out.print(n + " ");
        printNumberInAsc(n + 1);
    }
}