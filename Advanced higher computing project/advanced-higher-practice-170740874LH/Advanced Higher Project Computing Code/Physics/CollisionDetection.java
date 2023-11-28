package Physics;

import GameOne.Projectile;
import GameOne.Target;

public class CollisionDetection {
    public boolean squareAndCirlceCollsionDetection(Target square, Projectile circle) {
        //this is aniu inaccurate way of doing collisoin detection as instead of using the circles
        //actual hitbox I draw a bounding box around it but its a lot easier

        int radius = circle.getRadius();



        if (circle.getX() > (square.getX() - radius) && circle.getX() < (square.getX() + square.getWidth())) {
            if (circle.getY() > (square.getY() - radius) && circle.getY() < square.getY() + square.getHeight()) {
                return true;
            }
        }
        return false;

    }
}
