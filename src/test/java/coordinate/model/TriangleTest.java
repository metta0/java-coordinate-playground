package coordinate.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    void 삼각형_점3개가_직선인지(){
        assertThatThrownBy(() -> {
            Figure triangle = FigureFactory.create(Arrays.asList(new Point(1,1), new Point(2,2), new Point(3,3)));
        }).isInstanceOf(IllegalArgumentException.class);
        
    }

    @Test
    void 삼각형_점3개인지(){
        assertThatThrownBy(() -> {
            Figure triangle = FigureFactory.create(Arrays.asList(new Point(1,1), new Point(2,2), new Point(1,1)));
        }).isInstanceOf(IllegalArgumentException.class);
        
    }
    
    @Test
    void 삼각형_넓이구하기(){
            Figure triangle = FigureFactory.create(Arrays.asList(new Point(10,10), new Point(14,15), new Point(20,8)));
            assertEquals(triangle.getArea(), 29 , 0.1);
    }
}
