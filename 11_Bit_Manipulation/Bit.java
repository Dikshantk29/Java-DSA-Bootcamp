
public class Bit {
    public static void main(String[] args) {

        /*
         * Bitwise operator we have
         * binary and &
         * binary or |
         * binary xor ^
         * binary not ~
         * left shift <<
         * right shift >>
         * unsigned right shift >>
         */
      
        int a = 123;
        int b = 135;

        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);
        System.out.println(~a);
        System.out.println(a << 2);
        System.out.println(a >> 2);
        System.out.println(a >>> 2);
        
    }
}
