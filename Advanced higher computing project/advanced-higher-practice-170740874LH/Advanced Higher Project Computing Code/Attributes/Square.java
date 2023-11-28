package Attributes;
import java.awt.Color;
import java.awt.Graphics;

public class Square {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color colour;

    public Square (int x, int y, int width, int height, Color colour) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.colour = colour;
    }

    public void paint(Graphics g) {
        g.setColor(colour);
        g.fillRect(x, y, width, height);
        
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Color getColour() {
        return colour;
    } 

    public void setX (int newValue) {
        x = newValue;
    }
    public void setY (int newValue) {
        y = newValue;
    }
    public void setWidth (int newValue) {
        width = newValue;
    }
    public void setHeight (int newValue) {
        height = newValue;
    }
    


}
