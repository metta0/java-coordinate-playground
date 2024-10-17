package Model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

public class TriangleTest {
    Points points;
    Figure figure;

    @Test
    public void isTriangleTest(){
        points = new Points(Arrays.asList(new Point(1,1), new Point(1,3)));
        assertThatThrownBy(() -> {
            Figure figure = new Triangle(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getAreaTest(){
        points = new Points(Arrays.asList(new Point(10,10), new Point(14,15), new Point(20,8)));
        figure = new Triangle(points);

        assertEquals( 29 , figure.getArea(), 0.001);
    }
}
