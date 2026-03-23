import java.util.ArrayList;

public class ActivitySelection {
    // disjoint set of activities
    // max meeting in a room are the same problem
    public static void main(String[] args) {
      

        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };
        

        //end time basis sorted
        int maxAct =0;
        ArrayList<Integer> ans = new ArrayList<>();

 //last activity
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];
        for (int i = 1; i < start.length; i++) {
            if (start[i] >= lastEnd) {
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("Maximum activities: " + maxAct);
        System.out.println("Selected activities: " + ans);

    }
}