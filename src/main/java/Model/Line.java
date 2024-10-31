package Model;
import java.util.List;

public class Line extends Figure{
    public static final String RESULT_PREFIX = "두 점 사이 거리는";
    
    Points points;

    public Line(Points points){
        validationFigure(points);

        this.points = points;
    }

    @Override
    void validationFigure(Points points){
        if(points.size() != 2) throw new IllegalArgumentException("직선 객체 생성 시 점은 2개여야 합니다.");
    }

    public double getLineDistance(){
        List<Point> pointList = points.getPoints();

        double absDiffX = Math.abs(pointList.get(0).getX()-pointList.get(1).getX());
        double absDiffY = Math.abs(pointList.get(0).getY()-pointList.get(1).getY());

        return Math.sqrt(Math.pow(absDiffX,2) +
                             Math.pow(absDiffY,2));
    }

    @Override
    public double getArea(){
        return getLineDistance();
    }
    @Override
    public String showResult(){
        return RESULT_PREFIX + getArea();
    }
}
