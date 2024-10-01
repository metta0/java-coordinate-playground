import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CoordinateVariableTest {

    CoordinateVariable x;
    CoordinateVariable y;

    @Test
    public void variableValueTest(){
        x = new CoordinateVariable(10);
        y = new CoordinateVariable(10);
        assertEquals(x,y);
    }

    @Test
    public void illegalInputExceed24Test(){
        assertThatThrownBy(() -> {
            x = new CoordinateVariable(25);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void illegalInputbelow0Test(){
        assertThatThrownBy(() -> {
            x = new CoordinateVariable(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    
    
}
