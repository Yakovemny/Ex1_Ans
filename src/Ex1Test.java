import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(Ex1.isEmpty(" 1234345"));
        assertTrue(Ex1.isEmpty(" 1234345 "));
    }

    @Test
    void convertBasis() {
        String[] a = {"12345" , "3b4"};
        for(int i =0 ; i < a.length; i++){
            //assertEquals((Integer.parseInt(a[i])) , Ex1.convertBasis(a[i] , 10));
        }
        assertEquals(38 , Ex1.convert2Basis10("123b5"));
    }

    @Test
    void convert2Basis10() {
        String[] a = {"100111b2", "12345b6","012b5", "123bG", "EFbG"};
        int[] compare = {39,1865,7,291,239};
        for(int i =0 ; i < a.length; i++){
            assertEquals(compare[i], Ex1.convert2Basis10(a[i]));
        }
    }

    @Test
    void isValidBase() {
        String[] a = {"2","3","4","5","6","7","8","9", "A", "B", "C", "D", "E", "F", "G"};
        String[] falses = {"0" , "1" , "10", "11" , "12" , "13", "14", "15", "16" , "17"};
        for(int i =0 ; i < a.length; i++){
            assertEquals(true,Ex1.isValidBase(a[i]));
        }
        for(int i =0 ; i < falses.length; i++){
            assertEquals(false,Ex1.isValidBase(falses[i]));
        }

    }

    @Test
    void isValidForBase() {
        String[] a = {"100111b2", "12345b6","012b5", "123bG", "EFbG"};
        for(int i =0 ; i < a.length; i++){
            String[] temp = a[i].split("b");
            //if(Integer.parseInt(temp[i]) > 8)
            assertEquals(true, Ex1.isValidForBase(temp[0] , Integer.parseInt(String.valueOf(temp[1]))));
        }
    }

    @Test
    void testEquals() {
        String n1 = "1234b5";
        String n2 = "1234b5";
        String n3 = "12345";
        assertEquals(true, Ex1.equals(n1, n2));
        assertEquals(false, Ex1.equals(n1, n3));
    }

    @Test
    void maxIndex() {
    }
}