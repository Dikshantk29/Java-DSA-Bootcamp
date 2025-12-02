// package Patterns;

public class star {
    public static void main(String[] args) {
        // printStar1(5);
        // printStar2(5);
        printStar6(7);
    }

    static void printStar1(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");

            }
            System.out.println();

        }
    }

    static void printStar2(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("* ");

            }
            System.out.println();

        }
    }

    static void printStar3(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();

        }
    }

    static void printStar4(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();

        }
    }

    static void printStar5(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();

        }
    }

    static void printStar6(int n) {
        char ch ='A';

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if(ch>= 'A' && ch <= 'Z'){
                System.out.print(ch+" ");
                ch++;
                }
            }
            System.out.println();

        }
    }


    static void printStar7(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n-i+1; j++) {
                System.out.print(j+" ");
            }
            System.out.println();

        }
    }

}
