package Main;

import javax.swing.JButton;

import Inputs.ButtonInputs;

import java.awt.Color;

public class GamePage {
    private GameWindow window;
    private GamePanel panel;
    private ButtonInputs buttonInputs;
    private JButton game1Button;
    private JButton game2Button;
    GamePage () {
        
    }
    public void GamePageClicked (GameWindow window,GamePanel panel)  {
        this.window = window;
        this.panel = panel;
        //set up a button for each game
        setUpButtons ();
    }
    
    public void game1ButtonPressed () {
        game1Button.setVisible(false);
        game2Button.setVisible(false);
        panel.repaint();
        GameOne.Main startGameOne = new GameOne.Main(window,panel,buttonInputs);

    }
    public void loadButtons (ButtonInputs buttonInputs) {
        this.buttonInputs = buttonInputs;
        Button buttonFormat = new Button();
        game1Button = buttonFormat.setButton(50,250,200,200,"Game 1",Color.RED,Color.BLACK,false);
        game2Button = buttonFormat.setButton(300,250,200,200,"Game 2",Color.RED,Color.BLACK,false);

        buttonInputs.addButtonToList(game1Button);
        buttonInputs.addButtonToList(game2Button);
    }
    private void setUpButtons () {
        game1Button.setVisible(true);
        game2Button.setVisible(true);
        
        panel.add(game1Button);
        panel.add(game2Button);
        panel.repaint();
    }
}
