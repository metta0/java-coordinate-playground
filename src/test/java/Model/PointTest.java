package Model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PointTest {
    Point coordinate;
    
    @Test
    public void equalsTest(){
        coordinate = new Point(3,5);

        assertEquals(coordinate.getX(), 3);
        assertEquals(coordinate.getY(), 5);

    }
}
