package com.theforestvalley;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class IntegerTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public IntegerTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(IntegerTest.class);
    }

    public void testInt() {
        int a = 5;
        int b = 5;
        assertEquals(a, b);
        assertTrue(a == b);
    }

    public void testSmallInteger() {
        Integer a = 5;
        Integer b = 5;
        assertEquals(a, b);
        assertTrue(a == b);
    }

    public void testBigInteger() {
        Integer a = 50000;
        Integer b = 50000;
        assertEquals(a, b);
        assertFalse(a == b);
        assertTrue(a.equals(b));
        a = b;
        assertTrue(a == b);
    }


}
