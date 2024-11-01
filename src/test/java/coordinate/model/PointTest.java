package coordinate.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    void 좌표_생성(){
        assertThat(new Point(1,2)).isEqualTo(new Point(1,2));
    }
    
    @Test
    public void 좌표범위_벗어나는_에러(){
        assertThrows(IllegalArgumentException.class, ()-> {
            Point point = new Point(1,25);
    });

        assertThrows(IllegalArgumentException.class, ()-> {
            Point point = new Point(25,1);
    });

        assertThrows(IllegalArgumentException.class, ()-> {
            Point point = new Point(-1,24);
    });

        assertThrows(IllegalArgumentException.class, ()-> {
            Point point = new Point(24,-1);
    });
    }  

    @Test
    public void 주어진_좌표와_포인트를_비교() {
        assertTrue(new Point(1,2).isSame(1,2));
        assertFalse(new Point(1,3).isSame(1,2));
    }
    
    
}
