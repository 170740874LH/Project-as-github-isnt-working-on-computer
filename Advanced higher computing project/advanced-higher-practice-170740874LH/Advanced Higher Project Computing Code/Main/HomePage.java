package Main;
import java.util.Scanner;

import javax.swing.JButton;

import Inputs.ButtonInputs;

import java.awt.Color;

import GameOne.Main;

public class HomePage {
    private Scanner keyboard = new Scanner(System.in);

    private GameWindow window;
    private GamePanel panel;
    private JButton gamePageButton;
    private JButton leaderBoardPageButton;
    private ButtonInputs buttonInputs;
    

    private static GamePage gamePage;
    private static Leaderboard leaderboard;
        private GameWindow orignialWindow;
        private GamePanel orignialPanel;
        private ButtonInputs originalButtonInputs;
    public HomePage (GameWindow window, GamePanel panel, ButtonInputs buttonInputs) {
        
        this.window = window;
        this.panel = panel;
        this.buttonInputs = buttonInputs;
        buttonInputs.addHomePageClass(this);

        this.orignialWindow = window;
        this.orignialPanel = panel;
        this.buttonInputs = buttonInputs;

        panel.requestFocus();
        setUpButtons(buttonInputs);
        
         
    }
    public void resetHomePage () {
        this.window = orignialWindow;
        this.panel = orignialPanel;
        this.buttonInputs = originalButtonInputs;

        panel.requestFocus();
        setUpButtons(buttonInputs);
    }
    private void setUpButtons (ButtonInputs buttonInputs) {
        Button buttonFormat = new Button();
        //x,y,width,height,textInButton,textColour,backgroundColour,visible
        gamePageButton = buttonFormat.setButton(50,250,200,200,"Games",Color.RED,Color.BLACK,true);
        leaderBoardPageButton = buttonFormat.setButton(300,250,200,200,"Leaderboard",Color.RED,Color.BLACK,true);
        buttonInputs.addButtonToList(gamePageButton);
        buttonInputs.addButtonToList(leaderBoardPageButton);

        panel.add(gamePageButton);
        panel.add(leaderBoardPageButton);
        panel.repaint();

        setUpButtonsInCorrectOrderForLeaderBoardAndGame();

    }
    public void game1ButtonPressed () {
        //start game 1
        gamePageButton.setVisible(false);
        leaderBoardPageButton.setVisible(false);
        gamePage.game1ButtonPressed();
    }
    public void setUpButtonsInCorrectOrderForLeaderBoardAndGame() {
        gamePage = new GamePage();
        leaderboard = new Leaderboard();
        gamePage.loadButtons(buttonInputs);
        leaderboard.loadButtons(buttonInputs);
    }
    public void gamePageButtonPressed () {
        gamePageButton.setVisible(false);
        leaderBoardPageButton.setVisible(false);
        
        gamePage.GamePageClicked(window,panel);
    }
    public void leaderboardButtonPressed () {
        
        gamePageButton.setVisible(false);
        leaderBoardPageButton.setVisible(false);

        leaderboard.LeaderboardClicked(window,panel);
    }

   
}
