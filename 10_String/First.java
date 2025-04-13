
public class First {
    public static void main(String[] args) {
        char[] str = { 'a', 'b', 'c' };
        String str1 = "abc";
        String str2 = new String("abc");
        // as programer is same
        // string are immutable

        // concatination
        String str3 = str1 + str2;
        System.out.println(str3);

        System.out.println(str1.concat(str2));

        //charAt
        System.out.println(str1.charAt(0));

        //camparision
        System.out.println(str1.equals(str2));//return boolean value
        System.out.println(str1.equalsIgnoreCase(str2));



        //subString
        System.out.println(str1.substring(1));
        System.out.println(str1.substring(1, 2));//2 mean 2-1=>1   

      
    }
}
