package Model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Triangle extends Figure{
    Points points;

    public Triangle(Points points){
        
        validationFigure(points);

        this.points = points;
    }

    @Override
    void validationFigure(Points points){
        if(points.size() != 3) throw new IllegalArgumentException("삼각형은 점이 3개여야 합니다.");
    }

    @Override
    public double getArea(){
        List<Point> pointsList = points.getPoints();

        double a = new Line(new Points(pointsList.subList(0, 2))).getLineDistance();
        double b = new Line(new Points(pointsList.subList(1, 3))).getLineDistance();
        double c = new Line(new Points(Arrays.asList(pointsList.getFirst(), pointsList.getLast()))).getLineDistance();

        double s = (a+b+c)/2;
        
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    
}
