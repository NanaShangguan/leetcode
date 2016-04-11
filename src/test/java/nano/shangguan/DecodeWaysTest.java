package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/3/10.
 */
public class DecodeWaysTest extends TestCase {

    public void testNumDecodings() throws Exception {
        String s = "12";
        assertEquals("Wrong Answer", 2, new DecodeWays().numDecodings(s));
    }
}