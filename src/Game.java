import java.util.Scanner;

public class Game {
    private final Engine engine;

    public Game() {
        engine = new Engine();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        scanner.close();
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


}