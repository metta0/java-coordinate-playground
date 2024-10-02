package Model;
import java.util.ArrayList;
import java.util.List;

public class Coordinates {
    List<Coordinate> coordinates;

    public Coordinates(List<Coordinate> coordinatesList){
        coordinates = coordinatesList;
    }

    public int size(){
        return coordinates.size();
    }

    public List<int[]> getCoordinates(){
        ArrayList<int[]> result = new ArrayList<>();

        for(Coordinate coord : this.coordinates){
            result.add(new int[]{coord.getX(), coord.getY()});
        }

        return result;
    }

}
