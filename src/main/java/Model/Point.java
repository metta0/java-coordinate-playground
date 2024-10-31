package Model;

import java.util.Objects;

public class Point {
    private final PointVariable x;
    private final PointVariable y;

    public Point(int x,int y){
        this.x = new PointVariable(x);
        this.y= new PointVariable(y);
    }

    int getX(){
        return this.x.getValue();
    }

    int getY(){
        return this.y.getValue();
    }

    @Override
    public String toString(){
        return getX() + "," + getY();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }
    
}
