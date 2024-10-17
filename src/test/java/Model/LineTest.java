package Model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LineTest {

    Line line;

    @Test
    public void getDistanceTest() {
        Points points = new Points(Arrays.asList(new Point(1,1), new Point(2,2)));
        line = new Line(points);
        assertEquals( 1.414 , line.getLineDistance(), 0.001);
    }
    
}
