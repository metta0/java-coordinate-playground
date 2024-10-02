package Model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Model.Coordinate;

public class CoordinateTest {
    Coordinate coordinate;
    
    @Test
    public void equalsTest(){
        coordinate = new Coordinate(3,5);

        assertEquals(coordinate.getX(), 3);
        assertEquals(coordinate.getY(), 5);

    }
}
