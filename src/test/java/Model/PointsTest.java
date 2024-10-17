package Model;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;


public class PointsTest {

    Points points;

    @Test
    public void getLineDistanceTest() throws Exception{
        
        points = new Points(Arrays.asList(new Point(1,1), new Point(2,2)));
    }
    
    @Test
    public void getCoordinatesAsSetTest() throws Exception{
        points = new Points(Arrays.asList(new Point(1,1), new Point(2,2)));
        assertTrue(points.getPointsAsSet().contains("1,1"));
        assertFalse(points.getPointsAsSet().contains("1,2"));
    }
}