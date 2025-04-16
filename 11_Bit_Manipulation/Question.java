public class Question {

    public static void main(String[] args) {
        // find number is even or odd
        int number = 10;
        if ((number & 1) == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }

        // find number is power of 2
        int number1 = 16;
        if ((number1 & (number1 - 1)) == 0) {
            System.out.println("Power of 2");
        } else {
            System.out.println("Not Power of 2");
        }

        // get ith bit of number
        int number2 = 10;
        int i = 2;
        int bit = (number2 >> i) & 1;
        System.out.println(bit);

        // set ith bit of number
        int number3 = 10;
        int i1 = 2;
        int setBit = number3 | (1 << i1);
        System.out.println(setBit);

        // clear ith bit of number
        int number4 = 10;
        int i2 = 2;
        int clearBit = number4 & ~(1 << i2);
        System.out.println(clearBit);

        // update ith bit of number
        int number8 = 10;
        int i5 = 2;
        int updateBit = number8 ^ (1 << i5);
        System.out.println(updateBit);

        // toggle ith bit of number
        int number5 = 10;
        int i3 = 2;
        int toggleBit = number5 ^ (1 << i3);
        System.out.println(toggleBit);

        // count number of set bits
        int number6 = 10;
        int count = 0;
        while (number6 > 0) {
            count += number6 & 1;
            number6 >>= 1;
        }
        System.out.println(count);

        // count number of set bits using Brian Kernighan's algorithm
        int number7 = 10;
        int count1 = 0;
        while (number7 > 0) {
            count1++;
            number7 &= (number7 - 1);
        }
        System.out.println(count1);

        // swap two numbers using bitwise operator
        int a = 10;
        int b = 20;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
