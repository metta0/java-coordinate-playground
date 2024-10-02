package Model;
import java.util.Arrays;

public class Line {
    Coordinate coor1;
    Coordinate coor2;

    public Line(Coordinate coor1, Coordinate coor2){
        this.coor1 = coor1;
        this.coor2 = coor2;
    }

    public double getLineDistance(){
        double absDiffX = Math.abs(coor1.getX()-coor2.getX());
        double absDiffY = Math.abs(coor1.getY()-coor2.getY());

        return Math.sqrt(Math.pow(absDiffX,2) +
                             Math.pow(absDiffY,2));
    }
}
