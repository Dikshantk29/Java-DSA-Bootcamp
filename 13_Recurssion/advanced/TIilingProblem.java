
public class TIilingProblem {
    public static void main(String[] args) {
        
        int n = 5; // Length of the board
        System.out.println("Number of ways to tile a 2 x " + n + " board: " + tilingProblem(n));
        // Output: Number of ways to tile a 2 x 4 board: 5

    
    }
    // This function calculates the number of ways to tile a 2 x n board using 1 x 2 dominoes.
    // It uses recursion to find the number of ways to tile the board.
    // The time complexity is O(2^n) because it explores all possible combinations of placing dominoes.
    static int tilingProblem(int n) {
        // Base case: if the board length is 0, there is 1 way to tile it (do nothing).
        if (n == 0) {
            return 1;
        }
        // Base case: if the board length is 1, there is 1 way to tile it (place one domino vertically).
        if (n == 1) {
            return 1;
        }
        // Recursive case: place a domino vertically or horizontally and calculate the number of ways.
        return tilingProblem(n - 1) + tilingProblem(n - 2);
    }
}
