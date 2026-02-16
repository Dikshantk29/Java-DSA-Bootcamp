


public class PairFriens {
    public static void main(String[] args) {
        int n = 3; // Number of friends
        System.out.println("Number of ways to pair " + n + " friends: " + pairFriends(n));
    }

    static int pairFriends(int n) {
        
        if (n == 1|| n == 2) {
            return n;
        }
       
        return pairFriends(n - 1) + ((n - 1) * (pairFriends(n - 2)));
    }
}
