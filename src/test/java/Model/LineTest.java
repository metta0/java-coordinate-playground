package Model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import Model.Point;
import Model.Line;

public class LineTest {

    Line line;

    @Test
    public void getDistanceTest() throws Exception{
        Points points = new Points(Arrays.asList(new Point(1,1), new Point(2,2)));
        line = new Line(points);
        assertEquals( 1.414 , line.getLineDistance(), 0.001);
    }
    
}
