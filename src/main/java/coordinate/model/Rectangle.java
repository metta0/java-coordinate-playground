package coordinate.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Rectangle extends AbstractFigure {
    private static final int NUMBER_OF_POINTS = 4;
    private static final int NUMBER_OF_UNIQUE_POINTS = 2;
    private static final String RESULT_PREFIX = "사각형의 넓이는 ";
    private static final String ERROR_NUMBER_OF_POINTS = "점의 갯수가 " + NUMBER_OF_POINTS + "개 여야 합니다.";
    private static final String RECTANGLE_ERROR = "직사각형이어야 합니다.";

    Rectangle(List<Point> points){
        super(points);
        checkValidation(points);
    }

    @Override
    public void checkValidation(List<Point> points){
        if(isPointCountInvalid(points)) throw new IllegalArgumentException(ERROR_NUMBER_OF_POINTS);
        if(isPointRectangle(points)) throw new IllegalArgumentException(RECTANGLE_ERROR);
    }

    private boolean isPointCountInvalid(List<Point> points){
        Set<Point> pointSet = new HashSet<>(points);

        return pointSet.size() != NUMBER_OF_POINTS;
    }

    private boolean isPointRectangle(List<Point> points){
        Set<Integer> xOfPoints = removeDuplicationOfX(points);
        Set<Integer> yOfPoints = removeDuplicationOfY(points);
        
        return hasNoTwoValues(xOfPoints) || hasNoTwoValues(yOfPoints);
    }

    private Set<Integer> removeDuplicationOfX(List<Point> points){
        return removeDuplications(points, Point::getX);
    }

    private Set<Integer> removeDuplicationOfY(List<Point> points){
        return removeDuplications(points, Point::getY);
    }

    private Set<Integer> removeDuplications(List<Point> points, Function<Point, Integer> function){
        return points.stream()
               .map(function)
               .collect(Collectors.toSet());
    }

    private boolean hasNoTwoValues(Set<Integer> values){
        return values.size() != NUMBER_OF_UNIQUE_POINTS;
    }

    @Override
    public double getArea(){        
        int differenceOfX = getDifference(removeDuplicationOfX(getPoints()));
        int differenceOfY = getDifference(removeDuplicationOfY(getPoints()));

        return differenceOfX * differenceOfY;
    }

    private int getDifference(Set<Integer> values){
        return Math.abs(values.stream().collect(Collectors.toList()).get(1) - values.stream().collect(Collectors.toList()).get(0));
    }

    @Override
    public String areaInfo(){
        return RESULT_PREFIX + getArea();
    }
}
