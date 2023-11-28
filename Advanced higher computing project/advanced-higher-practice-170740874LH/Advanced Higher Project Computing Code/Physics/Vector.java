package Physics;

public class Vector {
    private double xVelocity;
    private double yVelocity;
    private double velocity;
    private double angleDegrees;
    private double angleRadians;
    public Vector (double velocity,double angleDegrees) {
        this.velocity = velocity;
        this.angleDegrees = angleDegrees;
        this.angleRadians = Math.toRadians(angleDegrees);
        this.xVelocity = velocity*Math.cos(angleRadians);
        this.yVelocity = velocity*Math.sin(angleRadians);
    }
    public void reset () {
        xVelocity = 0;
        yVelocity = 0;
        velocity = 0;
        angleDegrees = 0;
        angleRadians = 0;
    }
    public double getXVelocity() {
        return xVelocity;
    }
    public double getYVelocity() {
        return yVelocity;
    }
    public double getVelocity() {
        return velocity;
    }
    public double getAngleDegrees() {
        return angleDegrees;
    }
    public double getAngleRadians() {
        return angleRadians;
    }
}
