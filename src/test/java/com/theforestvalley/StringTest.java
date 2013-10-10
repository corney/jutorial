package com.theforestvalley;

import org.junit.Assert;
import org.junit.Test;


/**
 * User: corney
 * Date: 10.10.13
 * Time: 18:00
 */
public class StringTest {

    public static final int STRING_LENGTH = 100000;
    private String a;


    interface Profilable {
        void process();
    }

    private void profile(String name, Profilable p) {
        long t1 = System.currentTimeMillis();
        p.process();
        long t2 = System.currentTimeMillis();
        long difference = t2 - t1;
        System.out.println("[ " + name + "] Execution time: " + difference + " ms");
    }

    @Test
    public void testString() {
        String hello = "hello";
        String string = "string";
        String a = "hello string";
        String b = "hello string";
        String c = "Hello String";
        String d = hello + " " + string;

        Assert.assertTrue(a == b);
        Assert.assertTrue(a.equals(b));
        Assert.assertFalse(a.equals(c));
        Assert.assertTrue(a.equalsIgnoreCase(c));


        Assert.assertFalse(a == d);
        Assert.assertTrue(a.equals(d));
    }

    //@Test
    public void testStringConcat1() {
        a = "";

        Profilable p = new Profilable() {

            @Override
            public void process() {
                for (int i = 0; i < STRING_LENGTH; i++) {
                    a += " ";
                }
            }
        };
        profile("Test 1", p);

        Assert.assertEquals(STRING_LENGTH, a.length());
    }

    @Test
    public void testStringConcat2() {
        final StringBuilder b = new StringBuilder();

        Profilable p = new Profilable() {

            @Override
            public void process() {
                for (int i = 0; i < STRING_LENGTH; i++) {
                    b.append(" ");
                }
            }
        };
        profile("Test 2", p);

        Assert.assertEquals(STRING_LENGTH, b.length());
    }

    @Test
    public void testStringConcat3() {
        final StringBuilder b = new StringBuilder(STRING_LENGTH);

        Profilable p = new Profilable() {

            @Override
            public void process() {
                for (int i = 0; i < STRING_LENGTH; i++) {
                    b.append(" ");
                }
            }
        };
        profile("Test 3", p);

        Assert.assertEquals(STRING_LENGTH, b.length());
    }

    private String join(String join, String[] a) {
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for (String s: a) {
            if (first) {
                first = false;
            } else {
                builder.append(join);
            }
            builder.append(s);
        }
        return builder.toString();
    }

    @Test
    public void testSplitJoin() {
        String toSplit = "You're lost little girl ";
        String[] a1 = toSplit.split(" ");
        String[] a2 = toSplit.split(" ", -1);
        String[] a3 = toSplit.split(" ", -2);
        String[] a4 = toSplit.split(" ", 2);
        String[] a5 = toSplit.split(" ", 6);

        Assert.assertEquals(2, a4.length);
        Assert.assertEquals(4, a1.length);
        Assert.assertEquals(5, a5.length);
        Assert.assertEquals(5, a2.length);
        Assert.assertEquals(5, a3.length);
        Assert.assertEquals("You're", a4[0]);
        Assert.assertEquals("lost little girl ", a4[1]);
        Assert.assertEquals("You're", a5[0]);
        Assert.assertEquals("lost", a5[1]);
        Assert.assertEquals("little", a5[2]);
        Assert.assertEquals("girl", a5[3]);
        Assert.assertEquals("", a5[4]);

        String joined = join(" ", a2);


        Assert.assertEquals(toSplit, joined);

    }
}
