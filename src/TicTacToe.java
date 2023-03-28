import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();

        while (!gameOver()) {
            playerMove();
            displayBoard();
            switchPlayer();
        }

        char winner = checkWinner();
        if (winner != '-') {
            System.out.println("Congratulations " + winner + ", you win!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.print("Player " + currentPlayer + ", enter row (1-3) and column (1-3) separated by a space: ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!isValidMove(row, col));
        board[row][col] = currentPlayer;
    }

    public static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid move: row and column must be between 1 and 3.");
            return false;
        } else if (board[row][col] != '-') {
            System.out.println("Invalid move: spot is already taken.");
            return false;
        } else {
            return true;
        }
    }

    public static boolean gameOver() {
        if (checkWinner() != '-') {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public static char checkWinner() {
        // check rows
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }

        // check columns
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return board[0][j];
            }
        }

        // check other diagonal
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return board[0][2];
        }

        // no winner yet
        return '-';
    }

    public static void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }
}


