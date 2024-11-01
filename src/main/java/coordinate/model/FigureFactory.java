package coordinate.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
    private static final int NUM_OF_POINTS_OF_LINE = 2;
    private static final int NUM_OF_POINTS_OF_TRIANGLE = 3;
    private static final int NUM_OF_POINTS_OF_RECTANGLE = 4;
    private static final Map<Integer, Function<List<Point>, Figure>> creator = new HashMap<>();
    
    static{
        creator.put(NUM_OF_POINTS_OF_LINE, Line::new);
        creator.put(NUM_OF_POINTS_OF_TRIANGLE, Triangle::new);
        creator.put(NUM_OF_POINTS_OF_RECTANGLE, Rectangle::new);
    }

    public static Figure create(List<Point> points){
        if(points == null) throw new IllegalArgumentException();
        
        return creator.get(points.size()).apply(points);
    }
}
