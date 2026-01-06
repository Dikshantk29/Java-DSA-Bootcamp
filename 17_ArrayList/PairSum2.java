public class PairSum2 {
    //its is sorted and rotated arraylist
    public static void main(String[] args) {
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println(pairSumRotated(list, target));
    }   
    static boolean pairSumRotated(java.util.ArrayList<Integer> list, int target) {
        int n = list.size();
        int breakPoint = -1;
        for (int i = 0; i < n; i++) {
            if (list.get(i) > list.get(i + 1)) {
                breakPoint = i;
                break;
            }
        }
        int left = (breakPoint + 1); //smallest element
        int right = breakPoint; //largest element
        while (left != right) {
            int sum = list.get(left) + list.get(right);
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left = (left + 1) % n;
            } else {
                right = (n + right - 1) % n;
            }
        }
        return false;
    }

}
