public class PairSum {
    
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 6, 7, 8, 9};
        int target = 10;
        System.out.println(pairSum(arr, target));

        System.out.println(pairSumBruteForce(arr, target));
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(6);        
        list.add(7);
        list.add(8);
        list.add(9);
        System.out.println(pairSumArrayList(list, target));
    }

    // two pointer approach O(n)

    static boolean pairSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }



    // brute force approach O(n^2)    
    static boolean pairSumBruteForce(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;                
                }
            }
        }
        return false;
    }

   // ArrayList
    static boolean pairSumArrayList(java.util.ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }


}
