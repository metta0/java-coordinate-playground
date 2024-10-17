package Model;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PointVariableTest {

    PointVariable x;
    PointVariable y;

    @Test
    public void variableValueTest(){
        x = new PointVariable(10);
        y = new PointVariable(10);
        assertEquals(x,y);
    }

    @Test
    public void illegalInputExceed24Test(){
        assertThatThrownBy(() -> {
            x = new PointVariable(25);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void illegalInputbelow0Test(){
        assertThatThrownBy(() -> {
            x = new PointVariable(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    
    
}
