import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Ex1Test {

    @Test
    void isNumber() {
        //“100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
        assertFalse(Ex1.isNumber(""));
        assertFalse(Ex1.isNumber("b"));
        assertFalse(Ex1.isNumber("b2"));
        assertFalse(Ex1.isNumber("0b1"));
        assertFalse(Ex1.isNumber("-3b3"));
        assertFalse(Ex1.isNumber("3b3"));
        assertFalse(Ex1.isNumber("4b4"));
        assertFalse(Ex1.isNumber("3 b4"));
        assertFalse(Ex1.isNumber("3 b 4"));
        assertFalse(Ex1.isNumber("123b"));
        assertTrue(Ex1.isNumber("12345b6"));
        assertTrue(Ex1.isNumber("100111b2"));
        assertTrue(Ex1.isNumber("012b5"));
        assertTrue(Ex1.isNumber("123bG"));
        assertTrue(Ex1.isNumber("EFbG"));
        assertTrue(Ex1.isNumber("1234"));

    }

    @Test
    void isEmpty() {
        assertTrue(Ex1.isEmpty("1234 345"));
    }
}