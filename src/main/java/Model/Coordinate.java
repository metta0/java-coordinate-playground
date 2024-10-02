package Model;

public class Coordinate {
    CoordinateVariable x;
    CoordinateVariable y;

    public Coordinate(int x,int y){
        this.x = new CoordinateVariable(x);
        this.y= new CoordinateVariable(y);
    }

    int getX(){
        return this.x.getValue();
    }

    int getY(){
        return this.y.getValue();
    }
    
}
