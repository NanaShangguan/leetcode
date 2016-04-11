package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/4/11.
 */
public class SuperUglyNumberTest extends TestCase {

    public void testNthSuperUglyNumber() throws Exception {
        int[] primes = {2, 7, 13, 19};
        int n = 9;
        assertEquals("WA", 19, new SuperUglyNumber().nthSuperUglyNumber(n, primes));
    }
}