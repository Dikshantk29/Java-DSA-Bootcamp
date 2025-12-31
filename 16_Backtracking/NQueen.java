public class NQueen {
    static int count = 0;// total board printed

    public static void main(String[] args) {
        int n = 4;

        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'X';
            }
        }
        solveNQueen(board, 0);
        System.out.println("count :" + count);
    }

    static void solveNQueen(char[][] board, int row) {

        if (row == board.length) {
            printBoard(board);
            count++;
            return;
        }

        // kaam
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                solveNQueen(board, row + 1);
                board[row][j] = 'X';

            }
        }

    }

    static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---- Chess Board ----");
    }

    static boolean isSafe(char[][] board, int row, int col) {

        // check vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // check diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // check diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
