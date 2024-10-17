package Model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


public class PointsTest {

    Points points;

    @Test
    public void getPointsTest(){
        points = new Points(Arrays.asList(new Point(1,1), new Point(2,2)));

        List<Point> newPoints = points.getPoints();
        assertEquals(1, newPoints.get(0).getX());
        assertEquals(1, newPoints.get(0).getY());
        newPoints.remove(0);
        
        List<Point> newPoints2 = points.getPoints();
        assertEquals(1, newPoints2.get(0).getX());
        assertNotEquals(1, newPoints.get(0).getX());
    }

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