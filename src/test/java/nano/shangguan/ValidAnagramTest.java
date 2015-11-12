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
 * Created by Nano on 2015/11/10.
 */
@RunWith(Parameterized.class)
public class ValidAnagramTest extends TestCase {
    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                { "anagram", "nagaram", true }
                , { "rat", "car", false }
                , { "anagrmm", "nagaree", false }
        });
    }

    private String input1, input2;
    private boolean expected;
    private ValidAnagram validAnagram;

    public ValidAnagramTest(String input1, String input2, boolean expected) {
        this.input1 = input1;
        this.input2 = input2;
        this.expected = expected;
        validAnagram = new ValidAnagram();
    }

    @Test
    public void testIsAnagram() throws Exception {
        assertEquals("Wrong Answer [" + input1 + ", " + input2 + "]", expected, validAnagram.isAnagram(input1, input2));
    }
}