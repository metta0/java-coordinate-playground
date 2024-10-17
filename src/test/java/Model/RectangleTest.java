package Model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

public class RectangleTest {
    Points points;

    @Test
    public void isRectangleTest(){
        points = new Points(Arrays.asList(new Point(1,1), new Point(1,3), new Point(2,1), new Point(2,2)));
        assertThatThrownBy(() -> {
            Rectangle rectangle = new Rectangle(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getAreaTest(){
        points = new Points(Arrays.asList(new Point(1,1), new Point(1,4), new Point(3,1), new Point(3,4)));
        Rectangle rectangle = new Rectangle(points);

        assertEquals( 6.0 , rectangle.getArea(), 0.001);
    }


}
    
