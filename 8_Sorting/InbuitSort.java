
import java.util.*;
import java.util.Collections;
public class InbuitSort {
    public static void main(String[] args) {
        Integer[] arr = { 5, 4, 3, 2, 1 };//Object array
        
        try {
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));

            Arrays.sort(arr, Collections.reverseOrder());
            System.out.println(Arrays.toString(arr));
        } catch (NullPointerException e) {
            System.out.println("Array is null. Please provide a valid array.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
