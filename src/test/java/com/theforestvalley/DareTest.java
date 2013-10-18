package com.theforestvalley;


import org.junit.Assert;
import org.junit.Test;

/**
 * User: corney
 * Date: 15.10.13
 * Time: 17:53
 */
public class DareTest {

    @Test
    public void stringReverse() {
        String a = "a bcd efg hij";
        StringBuilder builder = new StringBuilder();

        for (int i = a.length() - 1; i >= 0; i--) {
            builder.append(a.charAt(i));
        }
        Assert.assertEquals("jih gfe dcb a", builder.toString());
    }

    @Test
    public void countA() {
        String b = "a s j a l a l a e a";

        int aCount = 0;

        for (int i = 0 ; i < b.length(); i++)  {
            if (b.charAt(i) == 'a') {
                aCount++;
            }
        }

        Assert.assertEquals(5, aCount);
    }

    @Test
    public void swapWords() {
        String a = "hello to magic world";
        String b = "world.magic.to.hello";
        String c = "";
        StringBuilder builder = new StringBuilder();

        String[] strings = a.split(" ");
        for ( int i = strings.length - 1; i >= 0; i--) {
            builder.append(strings[i]);
            if (i != 0 ) {
                builder.append(".");
            }

        //    c += strings[i];
        }

        Assert.assertEquals(b, builder.toString());
       // Assert.assertEquals(b, c);
    }

    @Test
    public void revert() {
        int[] a = {21, 2, 2004, 19, 12, 1976, 11, 11, 123, 456, 0, 8};
        final int[] b = {8, 0, 456, 123, 11, 11, 1976, 12, 19, 2004, 2, 21};
        // int[] c = new int[a.length];
        // Даша пишет комментарий

        for (int i = a.length - 1; i >= a.length/2; i--){
            int c = a[a.length - 1 - i];
            a[a.length - 1 - i] = a[i];
            a[i] = c;
        }

        Assert.assertArrayEquals(b, a);
    }

    @Test
    public void multiplyRevert() {
        int[] a = {2, 5, 6, 8, 9, 12};
        final int[] sample = {24, 18, 16, 12, 10, 4};

        int factor = 2;
        for (int i = a.length - 1; i >= a.length/2; i--){

            int c = a[a.length - 1 - i];
            a[a.length - 1 - i] = a[i];
            a[i] = c;
        }

        for (int i = 0; i < a.length; i++){
            a[i] =a [i]*factor;
        }


        Assert.assertArrayEquals(sample, a);

    }
}
