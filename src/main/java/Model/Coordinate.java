package Model;

public class Coordinate {
    CoordinateVariable x;
    CoordinateVariable y;

    Coordinate(int x,int y){
        this.x = new CoordinateVariable(x);
        this.y= new CoordinateVariable(y);
    }

    double getX(){
        return this.x.getValue();
    }

    double getY(){
        return this.y.getValue();
    }
    
}
