package coordinate.model;

import java.util.List;

public abstract class AbstractFigure implements Figure{
    static final String ERROR_FIGURE_NULL = "올바른 Point 값이 아닙니다";
    private final List<Point> points;

    AbstractFigure(List<Point> points){
        if(points == null || points.isEmpty()) throw new IllegalArgumentException(ERROR_FIGURE_NULL);

        this.points = points;
    }

    @Override
    public List<Point> getPoints(){
        return this.points;
    }

    @Override
    public boolean hasPoint(int x, int y){
        return this.points.contains(new Point(x, y));
    }

}
