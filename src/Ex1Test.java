import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Ex1Test {

    @Test
    void isNumber() {
        assertFalse(Ex1.isNumber(""));
        assertFalse(Ex1.isNumber("b"));
        assertTrue(Ex1.isNumber("1b"));
    }
}