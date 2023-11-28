package GameOne;

import Attributes.Square;
import java.awt.Color;

public class Slider extends Square{
    private int x;
    private int y;
    private int width;
    private int height;
    private Color colour;

    public Slider (int x, int y, int width, int height, Color colour) {
        super(x, y, width, height, colour);
        
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.colour = colour;
    }
}
