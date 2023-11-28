package GameOne;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;


import Inputs.ButtonInputs;
import Main.GamePanel;
import Main.GameWindow;
import Main.HomePage;
import Physics.CollisionDetection;
import Physics.EquationsOfMotions;
import Physics.Vector;


public class GameLoop {
    private final int maxVelocity = 85;
    private double angle;

    Timer timer;

        GameWindow window;
        GamePanel panel;
        ButtonInputs buttonInputs;
        Player player;
        Projectile projectile;
        PowerBar powerBar;
        AngleBar angleBar;
        Slider powerBarSlider;
        Slider angleBarSlider;
        Target target;
        JLabel livesAndScoreLabel;
    boolean spacePressed = false;
    private int sliderUpperBound;
    private int sliderLowerBound;
    private boolean sliderMovingUp = true;
    private boolean powerBarSliderMoving = true;
    private boolean slidersLockedIn = false;
    private boolean doneVelocityAndAngleCalculations = false;

    private Vector velocityVector;
    private double realVelocity;
    private EquationsOfMotions equationOfMotionFormulas = new EquationsOfMotions();
    private CollisionDetection collisionDetection = new CollisionDetection();
    private double time = 0;

    private double projectileStartingX;
    private double projectileStartingY;

    private int lifes = 3;
    private int score = 0;
    GameLoop(GameWindow window, GamePanel panel, ButtonInputs buttonInputs,
            Player player, Projectile projectile,
            PowerBar powerBar, AngleBar angleBar,
            Slider powerBarSlider, Slider angleBarSlider,
            Target target, JLabel livesAndScoreLabel) {

        
        //pretty sure this is pointless but oh well
        this.window = window;
        this.panel = panel;
        this.buttonInputs = buttonInputs;
        this.player = player;
        this.projectile = projectile;
        this.powerBar = powerBar;
        this.angleBar = angleBar;
        this.powerBarSlider = powerBarSlider;
        this.angleBarSlider = angleBarSlider;
        this.target = target;
        this.livesAndScoreLabel = livesAndScoreLabel;

        sliderUpperBound = powerBar.getY();
        sliderLowerBound = (powerBar.getY() + powerBar.getHeight());

        this.projectileStartingX = projectile.getX();
        this.projectileStartingY = projectile.getY();

        startGameLoop ();

    }
    public void startGameLoop () {
        
        timer = new Timer(10, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //get both bars locked in
                if (slidersLockedIn == false) {
                    lockInBars();
                }
                else if(doneVelocityAndAngleCalculations == false){
                    //calculate velocity and angle(in degrees) by postion of bars
                    realVelocity = calculateVelocity();
                    
                    angle = calculateAngle();
                    
                    //calculate x and y velocity
                    velocityVector = new Vector(realVelocity,angle);
                    doneVelocityAndAngleCalculations = true;

                }
                else {
                    if (collisionDetection.squareAndCirlceCollsionDetection(target,projectile)) {
                        score++;
                        
                        resetThrow();
                        //reset to start
                    }
                    else if (projectile.getY() + (2*projectile.getRadius()) > 750 ) {
                        lifes--;
                        if (lifes == 0) {

                            panel.game1Running = false;
                            panel.repaint();
                        }
                        resetThrow();
                    }
                    livesAndScoreLabel.setText("Score: " + score + " Lives: " + lifes);

                    //for x distance
                    double xDistance = equationOfMotionFormulas.FormulaOne(velocityVector.getXVelocity(),time,0);
                    double yDistance = -1*equationOfMotionFormulas.FormulaOne(velocityVector.getYVelocity(),time,-7);
                    //distance to move is the x distance + starting distance
                    double distanceToMoveX = (xDistance + projectileStartingX);
                    double distanceToMoveY = (yDistance + projectileStartingY);
                    projectile.setX((int) distanceToMoveX);
                    projectile.setY((int) distanceToMoveY);
                    //move the projectile now convert double x and y into int
                    
    
                    time = time + 0.1;
                    
                }
                panel.repaint();




            }
        });
            timer.start();
    }
    public void resetThrow () {
        sliderMovingUp = true;
        powerBarSliderMoving = true;
        slidersLockedIn = false;
        doneVelocityAndAngleCalculations = false;
        projectile.rest();
        velocityVector.reset();
        time = 0;
        timer.stop();
        target.setRandomSpawn();
        
        startGameLoop();
    }
    public double calculateAngle() {
        // a couple notes im doing the angle in relation to parrele along the xaxis but in the game i will 
        //just display it as 180 to 0 this is wrong just easy to look at and go that makes sense
        //negative angles will work as it will return a negative value due to the trig graphs

// 180
// 
// 0      
        double total = angleBar.getY() + angleBar.getHeight() - 50;
        double current;
        if (angleBarSlider.getY() > angleBar.getY() + angleBar.getHeight()/2) {
            current = angleBarSlider.getY() + angleBarSlider.getHeight() - 50;
        }
        else {
            current = angleBarSlider.getY() - 50;
        }
        double ratio = (current/total);
        double tempAngle = 180*ratio;
        tempAngle = 180 - tempAngle;
        angle = tempAngle - 90;
        return angle;
    }
    public double calculateVelocity() {
        //gets the furthest distance of the bar and where the slider is in relation calulates
        //a ratio that will then be converted into velocity
        double total = powerBar.getY() + powerBar.getHeight() - 50;
        double current;
        //this is 100 percent accurate but its good enough
        if (powerBarSlider.getY() > powerBar.getY() + powerBar.getHeight()/2) {
            current = powerBarSlider.getY() + powerBarSlider.getHeight() - 50;
        }
        else {
            current = powerBarSlider.getY() - 50;
        }
        double ratio = (current/total);
        double tempVelocity = maxVelocity*ratio;
        //this velocity is flipped around for how i want the bars due to the fact that 0,0 is in the top
        //this fixes it
        double velocity = maxVelocity - tempVelocity;

        return velocity;
    }
    public void lockInBars () {
        
        if (powerBarSliderMoving) {
            if (sliderMovingUp) {
                if (powerBarSlider.getY() - 3 < sliderUpperBound) {
                    sliderMovingUp = false;
                }
                else {
                    powerBarSlider.setY(powerBarSlider.getY() - 3);
                }
            }
            else {
                if (powerBarSlider.getY() + 3 + powerBarSlider.getHeight() > sliderLowerBound) {
                    sliderMovingUp = true;
                }
                else {
                    powerBarSlider.setY(powerBarSlider.getY() + 3);
                    }
                }   
        }
        else {
            if (sliderMovingUp) {
                if (angleBarSlider.getY() - 3 < sliderUpperBound) {
                    sliderMovingUp = false;
                }
                else {
                    angleBarSlider.setY(angleBarSlider.getY() - 3);
                }
            }
            else {
                if (angleBarSlider.getY() + 3 + angleBarSlider.getHeight() > sliderLowerBound) {
                    sliderMovingUp = true;
                }
                else {
                    angleBarSlider.setY(angleBarSlider.getY() + 3);
                }   
            }
        }  
    }
    public void giveKey (char key) {
        if ((int) key == 32) {
            if (powerBarSliderMoving) {
                powerBarSliderMoving = false;
            }
            else {
                slidersLockedIn = true;
            }
            
        }
    }
}
