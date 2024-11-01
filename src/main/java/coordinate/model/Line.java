package coordinate.model;

import java.util.List;

public class Line {
    private static final String SAME_POINTS_ERROR = "두 점이 같습니다.";
    private static final String NUMBER_OF_POINTS_ERROR = "점은 두개여야 합니다.";
    private static final String RESULT_PREFIX = "두 직선의 거리는 ";

    private static final Integer NUMBER_OF_POINTS = 2;

    private final List<Point> points;

    Line(List<Point> points){
        checkValidation(points);

        this.points = points;
    }

    private void checkValidation(List<Point> points){
        if(isPointCountInvalid(points)) throw new IllegalArgumentException(NUMBER_OF_POINTS_ERROR);
        if(isSamePoints(points)) throw new IllegalArgumentException(SAME_POINTS_ERROR);
    }
    
    private boolean isPointCountInvalid(List<Point> points){
        return points.size() != NUMBER_OF_POINTS;
    }

    private boolean isSamePoints(List<Point> points){
        return points.get(0).equals(points.get(1));
    }

    public double getDistance(){
        return points.get(0).calculateDistance(points.get(1));
    }

    public String printResult(){
        return RESULT_PREFIX + getDistance();
    }
}
