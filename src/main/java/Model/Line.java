package Model;
import java.util.Arrays;
import java.util.List;

public class Line {
    Points points;

    public Line(Points points){
        if(points.size() != 2) throw new IllegalArgumentException("직선 객체 생성 시 점은 2개여야 합니다.");

        this.points = points;
    }

    public double getLineDistance(){
        List<int[]> pointsList = points.getPointsAsList(); 
        
        int[] point1 = pointsList.get(0);
        int[] point2 = pointsList.get(1);
        
        double absDiffX = Math.abs(point1[0]-point2[0]);
        double absDiffY = Math.abs(point1[1]-point2[1]);

        return Math.sqrt(Math.pow(absDiffX,2) +
                             Math.pow(absDiffY,2));
    }
}
