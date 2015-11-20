package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2015/11/19.
 */
public class KthLargestElementTest extends TestCase {

    public void testFindKthLargest() throws Exception {
        assertEquals("Wrong Answer", 5, new KthLargestElement().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}