import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        String[] s = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA", "12b3" , "123b4" , "1234b5" ,
                "12345b6" , "123456b7","12b8" , "78b9" , "23bB" , "32bC" , "43bD", "45bE" , "56bF"};
        String[] expected = {"1b8", "1b8","1b8", "173b8" , "253b8" , "0", "5b8", "33b8","302b8","3511b8" , "54533b8", "12b8"
                , "107b8","31b8","46b8","67b8","75b8","121b8"};
        for(int i=0;i<s.length;i=i+1) {
            assertEquals(expected[i] , Ex1.int2Number(Ex1.number2Int(s[i]) , 8));
        }
    }
    @Test
    void maxIndexTest() {
        String[] a = {"100111b2", "12345b6","012b5", "123bG", "EFbG"};
        assertEquals(1 , Ex1.maxIndex(a));
    }
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
        String[] a = {"100111b2", "12345b6","012b5"};
        for(int i =0 ; i < a.length; i++){
            String[] temp = a[i].split("b");
            assertEquals(true, Ex1.isValidForBase(temp[0] , Ex1.convert2Basis10(temp[1])));
        }
        String[] b ={"123bG", "EFbG"};
        for(int i =0 ; i < b.length; i++){
            String[] temp = b[i].split("b");
            assertEquals(true, Ex1.isValidForBase(temp[0] , 16));
        }

        String[] c = {"34356b5", "123456b6", "012468b7"};
        for (int i = 0; i < c.length; i++) {
            String[] temp = c[i].split("b");
            assertEquals(false, Ex1.isValidForBase(temp[0], Ex1.convert2Basis10(temp[1])));
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


}