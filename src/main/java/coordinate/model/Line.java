package coordinate.model;

import java.util.List;

public class Line extends AbstractFigure {
    private static final String SAME_POINTS_ERROR = "두 점이 같습니다.";
    private static final String NUMBER_OF_POINTS_ERROR = "점은 두개여야 합니다.";
    private static final String RESULT_PREFIX = "두 직선의 거리는 ";

    private static final Integer NUMBER_OF_POINTS = 2;

    Line(List<Point> points){
        super(points);
        checkValidation(points);
    }

    @Override
    public void checkValidation(List<Point> points){
        if(isPointCountInvalid(points)) throw new IllegalArgumentException(NUMBER_OF_POINTS_ERROR);
        if(isSamePoints(points)) throw new IllegalArgumentException(SAME_POINTS_ERROR);
    }
    
    private boolean isPointCountInvalid(List<Point> points){
        return points.size() != NUMBER_OF_POINTS;
    }

    private boolean isSamePoints(List<Point> points){
        return points.get(0).equals(points.get(1));
    }

    @Override
    public double getArea(){
        return getPoints().get(0).calculateDistance(getPoints().get(1));
    }

    @Override
    public String areaInfo(){
        return RESULT_PREFIX + getArea();
    }
}
