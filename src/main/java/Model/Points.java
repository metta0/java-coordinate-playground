package Model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Points {
    final List<Point> points;

    public Points(List<Point> pointsList){
        this.points = new ArrayList<>(pointsList);
    }

    public int size(){
        return points.size();
    }

    public List<int[]> getPointsAsList(){
        ArrayList<int[]> result = new ArrayList<>();

        for(Point coord : this.points){
            result.add(new int[]{coord.getX(), coord.getY()});
        }

        return result;
    }

    public Set<String> getPointsAsSet(){
        Set<String> result = new HashSet<>();

        for(Point coord : this.points){
            result.add(coord.getX()+","+coord.getY());
        }
        
        return result;
    }

}
