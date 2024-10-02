package Model;
import java.util.Arrays;

public class Line {
    Coordinates coordinates;

    Line(Coordinate x, Coordinate y){
        coordinates = new Coordinates(Arrays.asList(x,y));
    }

    double getLineDistance() throws Exception{
        return coordinates.getLineDistance();
    }
}
