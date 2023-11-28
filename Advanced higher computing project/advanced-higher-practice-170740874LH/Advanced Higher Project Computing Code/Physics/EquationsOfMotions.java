package Physics;

public class EquationsOfMotions {
    //s = ut + 1/2 a t^2
    public double FormulaOne (double velocity,double time,double acceleration) {
        double distanceToMove = (velocity*time) + (0.5*acceleration*(time*time));
        return distanceToMove;
    }
    
}
