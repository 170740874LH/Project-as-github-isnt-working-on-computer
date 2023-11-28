package Main;
import Inputs.ButtonInputs;

import java.awt.Color;

import javax.swing.JButton;

public class Leaderboard {
    private GameWindow window;
    private GamePanel panel;
    private ButtonInputs buttonInputs;
    private JButton game1LeaderBoardButton;
    private JButton game2LeaderBoardButton;
    public Leaderboard () {

    }
    public void LeaderboardClicked (GameWindow window,GamePanel panel)  {
        this.window = window;
        this.panel = panel;
        //set up a button for each game
        setUpButtons ();
    }
    public void loadButtons (ButtonInputs buttonInputs) {
        this.buttonInputs = buttonInputs; 
        Button buttonFormat = new Button();
        game1LeaderBoardButton = buttonFormat.setButton(50,250,200,200,"Game 1 LB",Color.RED,Color.BLACK,false);
        game2LeaderBoardButton = buttonFormat.setButton(300,250,200,200,"Game 2 LB",Color.RED,Color.BLACK,false);

        buttonInputs.addButtonToList(game1LeaderBoardButton);
        buttonInputs.addButtonToList(game2LeaderBoardButton);
    }
    private void setUpButtons () {
        game1LeaderBoardButton.setVisible(true);
        game2LeaderBoardButton.setVisible(true);
        
        panel.add(game1LeaderBoardButton);
        panel.add(game2LeaderBoardButton);
        panel.repaint();
    }
}
