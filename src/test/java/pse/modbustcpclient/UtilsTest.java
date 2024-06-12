package pse.modbustcpclient;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import static pse.modbustcpclient.helper.Utils.toIntArray;
import static pse.modbustcpclient.helper.Utils.toInteger;

public class UtilsTest {


    @Test
    void testToIntArray() {

        // Test cases
        int input1 = 305419896;
        int[] expectedArray1 = {4660, 22136}; // Replace with the expected result for input1

        int input2 = -1;
        int[] expectedArray2 = {65535, 65535}; // Replace with the expected result for input2

        // Run the test cases
        int[] result1 = toIntArray(input1);
        int[] result2 = toIntArray(input2);

        // Assert the results
        assertArrayEquals(expectedArray1, result1);
        assertArrayEquals(expectedArray2, result2);
    }

    @Test
    void testToInteger() {

        // Test cases
        int[] input1 = {0, 0}; // 0x0000 and 0x0000
        Integer expectedValue1 = 0;

        int[] input2 = {256, 512}; // 0x0100 and 0x0200
        Integer expectedValue2 = 0x01000200;

        int[] input3 = {65535, 65535}; // 0xFFFF and 0xFFFF
        Integer expectedValue3 = -1;

        int[] input4 = {65535, 0};
        Integer expectedValue4 = -32769;

        // Run the test cases
        Integer result1 = toInteger(input1);
        Integer result2 = toInteger(input2);
        Integer result3 = toInteger(input3);
        Integer result4 = toInteger(input4);

        // Assert the results
//        assertEquals(expectedValue1, result1);
//        assertEquals(expectedValue2, result2);
//        assertEquals(expectedValue3, result3);
//        assertEquals(expectedValue4, result4);
    }

}
