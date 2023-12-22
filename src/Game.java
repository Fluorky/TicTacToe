import java.util.Scanner;

public class Game {
    private final Engine engine;

    public Game() {
        engine = new Engine();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Current board state:");
            printBoard(engine.getBoardState());

            Player currentPlayer = engine.getCurrentPlayer();
            System.out.println("Player " + currentPlayer.getSymbol() + " enter your move (row and column):");

            int [] move = currentPlayer.makeMove();
            int row = move[0];
            int col = move[1];

            if(engine.makeMove(row,col,currentPlayer)){
                if(engine.checkWin(currentPlayer)){
                    printBoard(engine.getBoardState());
                    System.out.println("Player "+ currentPlayer.getSymbol() + " wins!");
                    break;
                }
                else if(engine.isBoardFull())
                {
                    System.out.println("Nobody wins!. It's a draw!");
                    break;
                }
                else{
                    engine.switchPlayer();
                }
            }
            else{
                System.out.println("Invalid move. Try again!");
            }

        }
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