package ch.fhnw.algd1.converters.binary;

import org.junit.Assert;
import org.junit.Test;

public class BinConverterTest {

    @Test
    public void testToBinaryStringPositive() {
        testToBinaryString(0, "00000000");
        testToBinaryString(Byte.MAX_VALUE, "01111111");
        testToBinaryString(15, "00001111");
        testToBinaryString(16, "00010000");
        testToBinaryString(110, "01101110");
    }

    @Test
    public void testToBinaryStringNegative() {
        testToBinaryString(Byte.MIN_VALUE, "10000000");
        testToBinaryString(-15, "11110001");
        testToBinaryString(-16, "11110000");
        testToBinaryString(-110, "10010010");
    }

    private void testToBinaryString(int numberToTest, String expected) {
        String result = BinConverter.toBinaryString(numberToTest);
        Assert.assertEquals(expected, result);
    }

   @Test
    public void testParseBinaryStringPositive() {
       testParseBinaryString("00000000", 0);
       testParseBinaryString("01111111", Byte.MAX_VALUE);
       testParseBinaryString("00001111", 15);
       testParseBinaryString("00010000", 16);
       testParseBinaryString("01101110", 110);
    }

    @Test
    public void testParseBinaryStringNegative() {
        testParseBinaryString("10000000", Byte.MIN_VALUE);
        testParseBinaryString("11110001", -15);
        testParseBinaryString("11110000", -16);
        testParseBinaryString("10010010", -110);
    }

    private void testParseBinaryString(String textToTest, int expected) {
        int result = BinConverter.parseBinaryString(textToTest);
        Assert.assertEquals(expected, result);
    }
}
