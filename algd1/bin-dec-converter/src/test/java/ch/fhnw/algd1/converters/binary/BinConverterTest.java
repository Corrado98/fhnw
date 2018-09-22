package ch.fhnw.algd1.converters.binary;

import org.junit.Assert;
import org.junit.Test;

public class BinConverterTest {

    @Test
    public void testToBinaryString() {
        String result = BinConverter.toBinaryString(0);
        Assert.assertEquals("00000000", result);
    }

}
