public class Question {
    
    public static void main(String[] args) {
        //find number is even or odd
        int number = 10;
        if ((number & 1) == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }



        //find number is power of 2
        int number1 = 16;
        if ((number1 & (number1 - 1)) == 0) {
            System.out.println("Power of 2");
        } else {
            System.out.println("Not Power of 2");
        }
    }
}
