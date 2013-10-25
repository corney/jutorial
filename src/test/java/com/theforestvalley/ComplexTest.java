package com.theforestvalley;


import org.junit.Assert;
import org.junit.Test;

/**
 * User: corney
 * Date: 15.10.13
 * Time: 17:53
 */
public class ComplexTest {

    @Test
    public void addAndSub() {
        Complex a = new Complex(2, 3);
        Complex b = new Complex(3, 4);
        Complex sample = new Complex(1, 1);

        Assert.assertEquals(sample, b.substract(a));
        Assert.assertEquals(b, sample.add(a));
    }

    @Test
    public void multAndDiv (){
        Complex a = new Complex(2, 3);
        Complex b = new Complex(3, 4);
        Complex sample = new Complex(-6, 17);

        Assert.assertEquals(sample, b.multiply(a));
        Assert.assertEquals(a, sample.divine(b));
    }

    @Test
    public void addArray() {
        final Complex[] array1 = {
                new Complex(1, 4),
                new Complex(3, 7),
                new Complex(1, 2)
        };
        final Complex[] array2 = {
                new Complex(2, 2),
                new Complex(1, 5),
                new Complex(4, 2)
        };
        final Complex[] sample = {
                new Complex(3, 8),
                new Complex(4, 13),
                new Complex(5, 4)
        };
        Complex[] result = new Complex[sample.length];
        Assert.assertArrayEquals(sample, result);

    }

}
