import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculateMethodsTest {

    private CalculateMethods calc;

    @BeforeEach
    public void initTest(){
        calc = new CalculateMethods();
    }

    @Test
    public void testDivide(){
        assertEquals(10, calc.divide(100, 10));
    }

    @Test
    public void  testDivideByZero(){
        assertThrows(ArithmeticException.class, () -> calc.divide(0,0));
    }

}
