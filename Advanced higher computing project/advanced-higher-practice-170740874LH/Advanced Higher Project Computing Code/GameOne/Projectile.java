package GameOne;

import Attributes.Circle;
import java.awt.Color;

public class Projectile extends Circle{

    private int x;
    private int y;
    private int radius;
    private Color colour;
    private int startingX;
    private int startingY;
    Projectile (int x, int y, int radius, Color colour) {
        super(x, y, radius, colour);
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.colour = colour;
        this.startingX = x;
        this.startingY = y;
    }
    public void rest() {
        x = startingX;
        y= startingY;
    }
}
