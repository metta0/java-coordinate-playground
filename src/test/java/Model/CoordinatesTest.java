package Model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import Model.Coordinate;
import Model.Coordinates;

public class CoordinatesTest {

    Coordinates coordinates;

    @Test
    public void getLineDistanceTest() throws Exception{
        
        coordinates = new Coordinates(Arrays.asList(new Coordinate(1,1), new Coordinate(2,2)));
    }
    
    @Test
    public void getCoordinatesAsSetTest() throws Exception{
        coordinates = new Coordinates(Arrays.asList(new Coordinate(1,1), new Coordinate(2,2)));
        assertTrue(coordinates.getCoordinatesAsSet().contains("1,1"));
        assertFalse(coordinates.getCoordinatesAsSet().contains("1,2a"));
    }
}