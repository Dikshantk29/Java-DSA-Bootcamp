// package Patterns.AdvancedPattern;

public class pattern {
    public static void main(String[] args) {
        int n = 5;// row
        int m = 4; // col
        printFn(n, m);
        System.out.println();
        printFn1(n, m);
        System.out.println();
        printFn2(n);
        System.out.println();
        printFn3(n);
        System.out.println();
        printFn4(n);
        System.out.println();
        printFn5(n);
        System.out.println();
        printFn6(n);
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

    // inverted half pyramid
    public static void printFn1(int n, int m) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
               
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

    // floyed triangle
    public static void printFn2(int n) {
        int count = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(count++ + " ");
            }
            System.out.println();
        }
    }

    // Butterfly Pattern
    public static void printFn3(int n) {
        // 1st half
        for (int i = 1; i <= n; i++) {

            // star
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // space
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }

            // star
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
        // 2nd half
        for (int i = n; i >= 1; i--) {

            // star
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // space
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }

            // star
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

    // solid Rhombus
    public static void printFn4(int n) {

        for (int i = 1; i <= n; i++) {
            // space
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // hallow rhombus
    public static void printFn5(int n) {

        for (int i = 1; i <= n; i++) {
            // space
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 1; j <= n; j++) {

                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");

                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }

    // Diamond
    public static void printFn6(int n) {
        // 1st half
        for (int i = 1; i <= n; i++) {

            // space
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }

            // star
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

            System.out.println();

        }
        // 2nd half
        for (int i = n; i >= 1; i--) {
            // space
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }

            // star
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
