public class FindTheLargestWithLexi {
    public static void main(String[] args) {
      String str1= "apple", 
            str2= "mango";

        boolean st = str1.compareTo(str2) > 0;

        if (st) {
            System.out.println(str1);
        } else {
            System.out.println(str2);
        }
       
    }
}
