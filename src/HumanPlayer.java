import java.util.Scanner;

class HumanPlayer extends Player {
        public HumanPlayer(char symbol) {
            super(symbol);
        }

        @Override
        public int[] makeMove() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            return new int[]{row, col};
        }
}

