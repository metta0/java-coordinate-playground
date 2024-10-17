package Model;

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
    
}
