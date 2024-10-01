import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CoordinatesTest {

    Coordinates coordinates;

    @Test
    public void getLineDistanceTest() throws Exception{
        
        coordinates = new Coordinates(Arrays.asList(new Coordinate(1,1), new Coordinate(2,2)));

        assertEquals( 1.414 , coordinates.getLineDistance(), 0.001);
    }
}