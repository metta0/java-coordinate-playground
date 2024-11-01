package coordinate.model;

import java.util.Objects;

public class Point {
    private final String INDEX_OUT_OF_BOUNDS = "입력값은 0이상 24이하 입니다.";
    private static final int LOWER_LIMIT = 1;
    private static final int UPPER_LIMIT = 24;

    private final int x;
    private final int y;

    Point(int x, int y){
        if( isExceedsRange(x) || isExceedsRange(y)) throw new IllegalArgumentException(INDEX_OUT_OF_BOUNDS);

        this.x = x;
        this.y = y;
    }

    private boolean isExceedsRange(int value){
        return value <LOWER_LIMIT || value > UPPER_LIMIT;
    }
    
    public boolean isSame(int given_X, int given_Y){
        return this.x ==given_X && this.y == given_Y;
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
