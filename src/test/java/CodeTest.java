import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CodeTest {

    Code codeTest;

    @BeforeEach
    public void init(){
        codeTest = new Code();
    }

    @Test
    public void testSayHello(){
        assertEquals("Hello World", codeTest.sayHello());
    }
}
