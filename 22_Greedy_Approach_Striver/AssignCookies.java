
import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {

        int[] greed = { 1, 5, 3, 3, 4 };
        int[] size = { 4, 2, 1, 3, 1, 3 };
        
        int result = solve(greed, size);

        System.out.println("Result: " + result);

    }

    static int solve(int[] greed, int[] size){

        int n = greed.length;
        int m = size.length;

        int l=0,r=0;

        Arrays.sort(greed);
        Arrays.sort(size);

        while(l<m){

            if(greed[r]<= size[l]){
                r=r+1;
            }
            l=l+1;
        }

        return r;
    }
}
