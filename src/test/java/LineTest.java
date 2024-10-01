import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LineTest {

    Line line;

    @Test
    public void getDistanceTest() throws Exception{
        line = new Line(new Coordinate(1,1), new Coordinate(2,2));
        assertEquals( 1.414 , line.getLineDistance(), 0.001);
    }
    
}
