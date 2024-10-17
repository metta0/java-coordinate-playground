package Model;
import java.util.List;

public class Line {
    Points points;

    public Line(Points points){
        if(points.size() != 2) throw new IllegalArgumentException("직선 객체 생성 시 점은 2개여야 합니다.");

        this.points = points;
    }

    public double getLineDistance(){
        List<Point> pointList = points.getPoints();

        double absDiffX = Math.abs(pointList.get(0).getX()-pointList.get(1).getX());
        double absDiffY = Math.abs(pointList.get(0).getY()-pointList.get(1).getY());

        return Math.sqrt(Math.pow(absDiffX,2) +
                             Math.pow(absDiffY,2));
    }
}
