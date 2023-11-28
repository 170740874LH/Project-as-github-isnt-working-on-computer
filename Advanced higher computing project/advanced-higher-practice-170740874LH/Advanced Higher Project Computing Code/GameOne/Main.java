package GameOne;


import Inputs.ButtonInputs;
import Main.GamePanel;
import Main.GameWindow;
import Main.HomePage;

import java.awt.Color;
import java.awt.Label;
import java.util.Random;
import Main.Lable;
import javax.swing.JLabel;
public class Main {
    public boolean gameOneRunning;
    private GameWindow window;
    private GamePanel panel;
    private ButtonInputs buttonInputs;
    private GameLoop gameLoop;
    private Target target;
    private JLabel scoreAndLivesLabel = new JLabel();
    //need to add a power/angle bar and display with a line the path
    //add a player and a bulleye
    public Main (GameWindow window, GamePanel panel, ButtonInputs buttonInputs) {
        this.window = window;
        this.panel = panel;
        this.buttonInputs = buttonInputs;
        GameWindow.frame.setSize(1300,750);
        panel.addGameOneToKeyboardInputs(this);
        gameStart();
            
        
    }

    public void gameStart () {
        gameOneRunning = true;
        //adding player with projectile
        int startPlayerX = 50;
        int startPlayerY = 600;
        int startPlayerWidth = 50;
        int startPlayerHeight = 150;
        Player player = new Player(startPlayerX, startPlayerY, startPlayerWidth, startPlayerHeight, Color.RED);
        Projectile projectile = new Projectile((int) ((startPlayerX + startPlayerWidth+ 24)/2),(int) ((startPlayerHeight/2) + startPlayerY - 30), 25, Color.CYAN);

        //adding power and angle bar
        PowerBar powerBar = new PowerBar(50, 50, 50, 150, Color.ORANGE);
        AngleBar angleBar = new AngleBar(125, 50, 50, 150, Color.ORANGE);

        //add 2 sliders for power and angle bars
        Slider powerBarSlider = new Slider(50, 200, 50, 10, Color.RED);
        Slider angleBarSlider = new Slider(125, 200, 50, 10, Color.RED);

        //add the target
        Target target = setUpTarget ();
        Lable labelFormat = new Lable();
        scoreAndLivesLabel = new JLabel();
        scoreAndLivesLabel = labelFormat.setLable(250, 50, 400, 50, 28, "Score: 0" + " Lives: 3" );
        panel.add(scoreAndLivesLabel);
        panel.game1IsRunningGetReady(player,projectile,powerBar,angleBar,powerBarSlider,angleBarSlider,target);
        panel.repaint();

        gameLoop = new GameLoop(window,panel,buttonInputs,player,projectile,powerBar,angleBar,powerBarSlider,angleBarSlider,target,scoreAndLivesLabel);

    }
    public Target setUpTarget() {
        Target target = new Target(getRandomNumber(125,1150), 650, 100, 100, Color.BLUE);
        return target;
    }
    public int getRandomNumber (int lowerBound, int upperBound) {
        Random random = new Random();
        int randomNumber = random.nextInt(upperBound - lowerBound) + lowerBound;
        return randomNumber;
    }
    public void giveKey (char key) {
        gameLoop.giveKey(key);
    }
    
}
