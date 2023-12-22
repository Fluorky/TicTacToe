class Engine {
    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private Player currentPlayer;

    public Engine() {
        board = new Board();
        playerX = new Player('X');
        playerO = new Player('O');
        currentPlayer = playerX;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }
    public boolean isBoardFull() {
        return board.isBoardFull();
    }

    public char[][] getBoardState() {
        return board.getBoard();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }


    public boolean makeMove(int row, int col, Player currentPlayer)
    {
        return false;

    }
    public boolean checkWin(Player currentPlayer){
        return false;

    }
}