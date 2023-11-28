package Attributes;

import java.awt.Color;
import java.awt.Graphics;

public class Circle {
    private int x;
    private int y;
    private int radius;
    private Color colour;

    public Circle(int x, int y, int radius, Color colour) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.colour = colour;
    }
    public void paint(Graphics g) {  
        g.setColor(colour);
        g.fillOval(x,y,radius,radius);
    }
    public void setX(int ValuetoSet) {
        x = ValuetoSet;
    }
    public void setY(int ValuetoSet) {
        y = ValuetoSet;
    }
    public void setRadius(int ValuetoSet) {
        radius = ValuetoSet;
    }
    public void setColour(Color ValuetoSet) {
        colour = ValuetoSet;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getRadius() {
        return radius;
    }
    public Color getColour() {
        return colour;
    }

}
