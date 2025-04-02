package Patterns.AdvancedPattern;

public class pattern {
    public static void main(String[] args) {
        int n = 10;// row
        int m = 8; // col
        printFn(n, m);

    }

    // hallowed Star
    public static void printFn(int n, int m) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 || j == 1 || i == n || j == m) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // inverted & rotated half pyramid
    public static void printFn1(int n, int m) {
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++) {
                if(i == 1 || j == 1 || i == n || j == m){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
