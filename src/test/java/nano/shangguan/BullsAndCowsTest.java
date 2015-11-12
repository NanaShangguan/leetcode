package nano.shangguan;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nano on 2015/11/3.
 */
public class BullsAndCowsTest {

    @Test
    public void testGetHint() throws Exception {
        String result = new BullsAndCows().getHint("11", "10");
        Assert.assertEquals("结果错误", "1A0B", result);
    }
}