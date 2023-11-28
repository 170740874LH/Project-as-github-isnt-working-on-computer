package Main;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameOne.Player;
import GameOne.PowerBar;
import GameOne.Projectile;
import GameOne.Slider;
import GameOne.Target;
import GameOne.AngleBar;
import Inputs.KeyboardInputs;

import java.awt.Graphics;


public class GamePanel extends JPanel{

    //game 1 attributes
        private Player player;
        private Projectile projectile;
        private PowerBar powerBar;
        private AngleBar angleBar;
        private Slider powerBarSlider;
        private Slider angleBarSlider;
        private Target target;
    public boolean game1Running = false;
    public boolean game2Running = false;
    public GameOne.Main gameOneMain;

    Login loginPage;
    public GamePanel (Login game) {
        setLayout(null);
        addKeyListener(new KeyboardInputs(loginPage));
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        if (game1Running) {
            player.paint(g);
            projectile.paint(g);
            powerBar.paint(g);
            angleBar.paint(g);
            powerBarSlider.paint(g);
            angleBarSlider.paint(g);
            target.paint(g);
            
        }
        else if (game2Running) {
            
        }
        
    }
    public void addGameOneToKeyboardInputs(GameOne.Main gameOneMain) {
        this.gameOneMain = gameOneMain;
    }
    public void gameOneKeyPressed (char key) {
        gameOneMain.giveKey(key);
    }
    public void displayGameOneScore () {

    }
    public void game1IsRunningGetReady (Player player, Projectile projectile, 
                                        PowerBar powerBar, AngleBar angleBar,
                                        Slider powerBarSlider, Slider angleBarSlider,
                                        Target target) {
        game1Running = true;
        this.player = player;
        this.projectile = projectile;
        this.powerBar = powerBar;
        this.angleBar = angleBar;
        this.powerBarSlider = powerBarSlider;
        this.angleBarSlider = angleBarSlider;
        this.target = target;

    }
}
