package nano.shangguan;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Nano on 2015/11/11.
 */
@RunWith(Parameterized.class)
public class SortColorsTest extends TestCase {

    /**
     * TBD 改成随机生成
     * @return
     */
    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                { new int[]{ 0 }, "[0]" }
                , { new int[]{ 1 }, "[1]" }
                , { new int[]{ 2 }, "[2]" }
                , { new int[]{ 0, 1 }, "[0, 1]" }
                , { new int[]{ 0, 2 }, "[0, 2]" }
                , { new int[]{ 1, 0 }, "[0, 1]" }
                , { new int[]{ 2, 1 }, "[1, 2]" }
                , { new int[]{ 0, 1, 2 }, "[0, 1, 2]" }
                , { new int[]{ 2, 0, 1 }, "[0, 1, 2]" }
                , { new int[]{ 2, 1, 0 }, "[0, 1, 2]" }
                , { new int[]{ 0, 2, 1, 0, 2 }, "[0, 0, 1, 2, 2]" }
        });
    }

    private int[] input;
    private String expected;

    public SortColorsTest(int[] input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void testSortColors() throws Exception {
        new SortColors().sortColors(input);
        assertEquals("Wrong Answer", expected, Arrays.toString(input));
    }
}