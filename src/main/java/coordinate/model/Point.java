package coordinate.model;

import java.util.Objects;

public class Point {
    private final String INDEX_OUT_OF_BOUNDS = "잘못된 범위의 입력값입니다. 입력값은" + 
                                                LOWER_LIMIT + "이상" + UPPER_LIMIT + 
                                                "이하로 입력해주세요.";
    private static final int LOWER_LIMIT = 1;
    private static final int UPPER_LIMIT = 24;

    private final int x;
    private final int y;

    Point(int x, int y){
        checkRangeOf(x,y);

        this.x = x;
        this.y = y;
    }

    private void checkRangeOf(int x, int y){
        if(isExceedsRange(x) || isExceedsRange(y)) throw new IllegalArgumentException(INDEX_OUT_OF_BOUNDS);
    }

    private boolean isExceedsRange(int value){
        return value <LOWER_LIMIT || value > UPPER_LIMIT;
    }
    
    public boolean isSame(int given_X, int given_Y){
        return this.x ==given_X && this.y == given_Y;
    }

    public double calculateDistance(Point point) {
        return Math.sqrt(powDifference(this.x, point.x) + powDifference(this.y, point.y));
    }

    public double powDifference(int first, int second){
        return Math.pow((first - second),2);
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        
        Point object = (Point) obj;
        return this.x == object.x && this.y == object.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x,this.y);
    }
}
