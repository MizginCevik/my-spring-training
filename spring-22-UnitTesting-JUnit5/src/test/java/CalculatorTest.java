import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        System.out.println("Add method");
        int actual = Calculator.add(2,3);
        assertEquals(5,actual,"Test failed.");
    }

    @Test
    void testCase1() {
//        System.out.println("Test case 1");
        fail("Not implemented yet.");
    }

    @Test
    void testCase2() {
        System.out.println("Test case 2");
        assertEquals("add",Calculator.operator);
        assertTrue(Calculator.operator.equals("add"));
    }

    @Test
    void testCase3() {
        System.out.println("Test case 3");
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,3,2},"Arrays are not same");
    }

    @Test
    void testCase4() {
        System.out.println("Test case 4");

        String nullString = null;
        String notNullString = "Cydeo";

        assertNull(nullString);
        assertNotNull(notNullString);

        assertNull(notNullString);
        assertNotNull(nullString);

    }

    @Test
    void testCase5() {
        System.out.println("Test case 5");
    }

}