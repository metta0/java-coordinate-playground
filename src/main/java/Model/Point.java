package Model;

public class Point {
    PointVariable x;
    PointVariable y;

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
    
}
