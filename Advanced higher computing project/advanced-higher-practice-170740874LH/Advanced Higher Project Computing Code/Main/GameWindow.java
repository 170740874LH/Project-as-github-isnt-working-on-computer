package Main;
import javax.swing.JFrame;

import Main.GamePanel;

public class GameWindow {

    public static JFrame frame;

    public GameWindow (GamePanel gamePanel) {

        frame = new JFrame();

        frame.setSize(750,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
