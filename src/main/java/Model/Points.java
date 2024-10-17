package Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Points {
    private final List<Point> points;

    public Points(List<Point> pointsList){
        this.points = new ArrayList<>(pointsList);
    }

    public int size(){
        return points.size();
    }

    public List<Point> getPoints(){
        return new ArrayList(points);
    }

    public List<int[]> getPointsAsList(){
        return points.stream()
                     .map(point -> new int[]{point.getX(), point.getY()})
                     .toList();
    }

    public Set<String> getPointsAsSet(){
        return points.stream()
                     .map(Point::toString)
                     .collect(Collectors.toSet());
    }
}
