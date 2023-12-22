import java.util.Scanner;

class Player {
    private final char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public int[] makeMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your move (row and column): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }
}