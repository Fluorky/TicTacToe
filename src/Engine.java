class Engine {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;


    public Engine() {
        board = new Board();
        playerX = new Player('X');
        playerO = new Player('O');
        currentPlayer = playerX;
    }

    public Engine(HumanPlayer x, ComputerPlayer o) {
        board = new Board();
        playerX = x;
        playerO = o;
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

    public boolean makeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board.getBoard()[row][col] == '-') {
            board.getBoard()[row][col] = currentPlayer.getSymbol();
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board.getBoard()[i][0] == currentPlayer.getSymbol() && board.getBoard()[i][1] == currentPlayer.getSymbol() && board.getBoard()[i][2] == currentPlayer.getSymbol()) ||
                    (board.getBoard()[0][i] == currentPlayer.getSymbol() && board.getBoard()[1][i] == currentPlayer.getSymbol() && board.getBoard()[2][i] == currentPlayer.getSymbol())) {
                return true;
            }
        }

        // Check diagonals
        if ((board.getBoard()[0][0] == currentPlayer.getSymbol() && board.getBoard()[1][1] == currentPlayer.getSymbol() && board.getBoard()[2][2] == currentPlayer.getSymbol()) ||
                (board.getBoard()[0][2] == currentPlayer.getSymbol() && board.getBoard()[1][1] == currentPlayer.getSymbol() && board.getBoard()[2][0] == currentPlayer.getSymbol())) {
            return true;
        }

        return false;
    }

    public boolean makeMove(int row, int col, Player currentPlayer)
    {
        if (board.getBoard()[row][col] == '-') {
            if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                board.getBoard()[row][col] = currentPlayer.getSymbol();
                return true;
            }
        }
        return false;

    }
    public boolean checkWin(Player currentPlayer){
        // Check rows and columns
        char cP = currentPlayer.getSymbol();

        for(int i=0; i<3; i++){
            if((board.getBoard()[i][0]==cP && board.getBoard()[i][1]==cP && board.getBoard()[i][2]==cP)||
                    (board.getBoard()[0][i]==cP && board.getBoard()[1][i]==cP && board.getBoard()[2][i]==cP)){
                return true;
            }
        }

        //Check diagonals
        return ((board.getBoard()[0][0]==cP && board.getBoard()[1][1]==cP && board.getBoard()[2][2]==cP)||
                (board.getBoard()[2][0]==cP && board.getBoard()[1][1]==cP && board.getBoard()[0][2]==cP));

    }

    public boolean checkWin(char cP){
        // Check rows and columns


        for(int i=0; i<3; i++){
            if((board.getBoard()[i][0]==cP && board.getBoard()[i][1]==cP && board.getBoard()[i][2]==cP)||
                    (board.getBoard()[0][i]==cP && board.getBoard()[1][i]==cP && board.getBoard()[2][i]==cP)){
                return true;
            }
        }
        return ((board.getBoard()[0][0]==cP && board.getBoard()[1][1]==cP && board.getBoard()[2][2]==cP)||
                (board.getBoard()[2][0]==cP && board.getBoard()[1][1]==cP && board.getBoard()[0][2]==cP));

       /* //Check diagonals
        if((board.getBoard()[0][0]==cP && board.getBoard()[1][1]==cP && board.getBoard()[2][2]==cP)||
                (board.getBoard()[2][0]==cP && board.getBoard()[1][1]==cP && board.getBoard()[0][2]==cP)){
            return true;
        };*/

        //return false;
    }


}