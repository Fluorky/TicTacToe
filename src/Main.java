import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //Game game = new Game();
        //game.playGame();
        SwingUtilities.invokeLater(() -> new GameGui());
    }
}
