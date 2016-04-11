package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/3/1.
 */
public class DivideTwoIntegersTest extends TestCase {

    public void testDivide() throws Exception {
//        -2147483648
//                -1
        int dividend = -2147483648;
        int divisor = -1;
        assertEquals("Wrong Answer", dividend / divisor, new DivideTwoIntegers().divide(dividend, divisor));
    }
}