package coordinate.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void 라인_생성시_같은점인지_체크(){
        List<Point> points = new ArrayList(Arrays.asList(new Point(1,2), new Point(1,2)));
        
        assertThatThrownBy(()->{
            Figure line = FigureFactory.create(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 직선인경우_두점사이의거리_출력(){
        List<Point> points = new ArrayList(Arrays.asList(new Point(1,2), new Point(3,4)));
        Figure line = FigureFactory.create(points);
        assertEquals(line.getArea(), 2.828, 0.001);
    }
}
