import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGui extends JFrame  {



        private JButton[][] buttons;
        private Engine engine;

        public GameGui() {
            super("Tic Tac Toe");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 300);

            buttons = new JButton[3][3];
            engine = new Engine(new HumanPlayer('X'), new ComputerPlayer('O')); // Replace ComputerPlayer with HumanPlayer for 2 human players

            initializeButtons();
            setLayout(new GridLayout(3, 3));
            setVisible(true);
        }

        private void initializeButtons() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j] = new JButton("");
                    buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                    buttons[i][j].setFocusPainted(false);

                    int finalI = i;
                    int finalJ = j;
                    buttons[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            onButtonClick(finalI, finalJ);
                        }
                    });

                    add(buttons[i][j]);
                }
            }
        }

        private void onButtonClick(int row, int col) {
            if (engine.makeMove(row, col)){
                updateUI();
                if (engine.checkWin()) {
                    JOptionPane.showMessageDialog(this, "Player " + engine.getCurrentPlayer().getSymbol() + " wins!");
                    resetGame();
                } else if (engine.isBoardFull()) {
                    JOptionPane.showMessageDialog(this, "It's a draw!");
                    resetGame();
                } else {
                    engine.switchPlayer();
                    if (engine.getCurrentPlayer() instanceof ComputerPlayer) {
                        makeComputerMove();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid move. Try again.");
            }
        }
        public int[] recurrence() {
            int[] move = engine.getCurrentPlayer().makeMove();
            int row = move[0];
            int col = move[1];
            if (engine.makeMove(row, col)) {
                engine.makeMove(row, col);

            } else {
                recurrence();
            }
            return new int[]{row, col};
        }
        private void makeComputerMove() {

            int[] move = recurrence();
            int row = move[0];
            int col = move[1];

            buttons[row][col].setText(String.valueOf(engine.getCurrentPlayer().getSymbol()));
            buttons[row][col].setEnabled(false);
            updateUI();

            if (engine.checkWin()) {
                JOptionPane.showMessageDialog(this, "Player " + engine.getCurrentPlayer().getSymbol() + " wins!");
                resetGame();
            } else if (engine.isBoardFull()) {
                JOptionPane.showMessageDialog(this, "It's a draw!");
                resetGame();
            } else {
                engine.switchPlayer();
            }
        }

        private void updateUI() {
            char[][] board = engine.getBoardState();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setText(String.valueOf(board[i][j]));
                    buttons[i][j].setEnabled(board[i][j] == '-');
                }
            }
        }

        private void resetGame() {
            engine = new Engine(new HumanPlayer('X'), new ComputerPlayer('O'));
            updateUI();
        }


}



