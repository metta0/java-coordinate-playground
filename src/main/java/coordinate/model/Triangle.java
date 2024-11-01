package coordinate.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Triangle extends AbstractFigure{
    
    private static final int NUMBER_OF_POINTS = 3;
    private static final String RESULT_PREFIX = "삼각형의 넓이는 ";
    private static final String ERROR_NUMBER_OF_POINTS = "점의 갯수가 " + NUMBER_OF_POINTS + "개 여야 합니다.";
    private static final String ERROR_POINTS_ON_LINE = "점 3개가 한 직선 위에 있습니다.";

    Triangle(List<Point> points){
        super(points);
        checkValidation(points);
    }

    @Override
    public void checkValidation(List<Point> points) {
        if(isPointCountInvalid(points)) throw new IllegalArgumentException(ERROR_NUMBER_OF_POINTS);
        if(isStraightLine(points)) throw new IllegalArgumentException(ERROR_POINTS_ON_LINE);
    }

    private boolean isPointCountInvalid(List<Point> points){
        Set<Point> pointSet = new HashSet<>(points);
        
        return pointSet.size() != NUMBER_OF_POINTS;
    }
    
    private boolean isStraightLine(List<Point> points){
        double firstSlope = points.get(0).calculateSlope(points.get(1));
        double secondSlope = points.get(1).calculateSlope(points.get(2));

        return firstSlope == secondSlope;
    }

    @Override
    public double getArea(){
        List<Point> points = getPoints();

        double firstSide = points.get(0).calculateDistance(points.get(1));
        double secondSide = points.get(1).calculateDistance(points.get(2));
        double thirdSide = points.get(0).calculateDistance(points.get(2));
        
        double s = (firstSide + secondSide + thirdSide) / 2;

        return Math.sqrt(s * (s-firstSide) * (s-secondSide) * (s-thirdSide));
    }

    @Override
    public String getAreaInfo(){
        return RESULT_PREFIX + getArea();
    }
    
}
