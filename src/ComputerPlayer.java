import java.util.Random;

class ComputerPlayer extends Player {
    private Random random;

    public ComputerPlayer(char symbol) {
        super(symbol);
        this.random = new Random();
    }

    @Override
    public int[] makeMove() {
        System.out.println("Computer player is making a move...");
        int row = random.nextInt(3);
        int col = random.nextInt(3);
        return new int[]{row, col};
    }
}