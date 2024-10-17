package Model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Rectangle {
    Points points;

    public Rectangle(Points points){
        
        validationRectangle(points);

        this.points = points;
    }

    private void validationRectangle(Points points){
        if(points.size() != 4) throw new IllegalArgumentException("직사각형은 점이 4개여야 합니다.");
        
        if(isNotRectangle(points)) throw new IllegalArgumentException("이 사각형은 직사각형이 아닙니다.");
    }

    private boolean isNotRectangle(Points points){
        List<int[]> pointsList = points.getPointsAsList();

        Set<Integer> setX = pointsList.stream().map(point -> point[0]).collect(Collectors.toSet());
        Set<Integer> setY = pointsList.stream().map(point -> point[1]).collect(Collectors.toSet());
        
        if(setX.size() == 2 && setY.size() == 2) return false;

        return true;
    }

    public double getArea(){
        List<int[]> pointsList = points.getPointsAsList();

        Set<Integer> setX = pointsList.stream().map(point -> point[0]).collect(Collectors.toSet());
        Set<Integer> setY = pointsList.stream().map(point -> point[1]).collect(Collectors.toSet());
        
        return (setX.stream()
            .reduce((a,b) -> Math.abs(a - b))
            .orElse(0))
            *
            setY.stream()
            .reduce((a, b) -> Math.abs(a -b))
            .orElse(0) ;
    }

}
