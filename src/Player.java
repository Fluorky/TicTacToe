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

        int row = 0;
        int col = 0;
        do {
            System.out.println("Enter your move (row and column): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        }while(row>2||col>2);

        return new int[]{row, col};
    }
}