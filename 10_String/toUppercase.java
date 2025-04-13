public class toUppercase {
    public static void main(String[] args) {
        String str = "hello, world";
        System.out.println(str.toUpperCase());

        //Lowercase
        System.out.println(str.toLowerCase());

        //Titlecase
        System.out.println(str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toUpperCase()));

    }
    
}
