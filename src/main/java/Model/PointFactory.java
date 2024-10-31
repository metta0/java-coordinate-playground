package Model;

import java.util.List;

public class PointFactory {

    public static Points createPointsFromList(List<int[]> inputPoints){
        List<Point> pointsObj = inputPoints.stream()
                                           .map(point -> new Point(point[0], point[1]))
                                           .distinct()
                                           .toList();

        return new Points(pointsObj);
    }
}
