package coordinate.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RectangleTest {
    
    @Test
    void 점이_유효한지_4개(){
        List<Point> points = new ArrayList(Arrays.asList(new Point(1,1), new Point(1,1), new Point(3,1), new Point(3,3)));
        
        assertThatThrownBy(() -> {
            Rectangle rectangle = new Rectangle(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 점이_유효한지_직사각형(){
        List<Point> points = new ArrayList(Arrays.asList(new Point(1,1), new Point(1,2), new Point(3,1), new Point(3,3)));
        
        assertThatThrownBy(() -> {
            Rectangle rectangle = new Rectangle(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 직사각형_넓이구하기(){
        List<Point> points = new ArrayList(Arrays.asList(new Point(1,1), new Point(1,3), new Point(3,1), new Point(3,3)));
        Rectangle rectangle = new Rectangle(points);

        assertEquals(rectangle.getArea(), 4, 0.001);
        
    }

}
