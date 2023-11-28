package GameOne;

import java.awt.Color;
import java.util.Random;

import Attributes.Square;

public class Target extends Square{
    private int x;
    private int y;
    private int width;
    private int height;
    private Color colour;

    public Target (int x, int y, int width, int height, Color colour) {
        super(x, y, width, height, colour);
        
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.colour = colour;
    }
    public void setRandomSpawn () {
        setX(getRandomNumber(125,1150));
        
    } 
    public int getRandomNumber (int lowerBound, int upperBound) {
        Random random = new Random();
        int randomNumber = random.nextInt(upperBound - lowerBound) + lowerBound;
        return randomNumber;
    }
}
