package Model;
import java.util.List;

public class Coordinates {
    List<Coordinate> coordinates;

    Coordinates(List<Coordinate> coordinatesList){
        coordinates = coordinatesList;
    }

    double getLineDistance() throws Exception{
        if(coordinates.size() != 2) throw new RuntimeException();
        Coordinate coorFirst = coordinates.get(0);
        Coordinate coorSecond = coordinates.get(1);
        
        return Math.sqrt( Math.pow(coorFirst.getY()-coorSecond.getY(),2) +
                             Math.pow(coorFirst.getX()-coorSecond.getX(),2));
    }
}
