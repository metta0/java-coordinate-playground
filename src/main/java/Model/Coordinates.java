package Model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Coordinates {
    final List<Coordinate> coordinates;

    public Coordinates(List<Coordinate> coordinatesList){
        this.coordinates = new ArrayList<>(coordinatesList);
    }

    public int size(){
        return coordinates.size();
    }

    public List<int[]> getCoordinatesAsList(){
        ArrayList<int[]> result = new ArrayList<>();

        for(Coordinate coord : this.coordinates){
            result.add(new int[]{coord.getX(), coord.getY()});
        }

        return result;
    }

    public Set<String> getCoordinatesAsSet(){
        Set<String> result = new HashSet<>();

        for(Coordinate coord : this.coordinates){
            result.add(coord.getX()+","+coord.getY());
        }
        
        return result;
    }

}
