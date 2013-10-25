package com.theforestvalley;

/**
 * User: corney
 * Date: 25.10.13
 * Time: 18:04
 */
public class Complex {
    public final double r;
    public final double i;

    public Complex(double r, double i) {
        this.r = r;
        this.i = i;
    }

    public Complex add(Complex other) {

        return new Complex(r + other.r, i + other.i);
    }

    public Complex substract(Complex other) {
         return new Complex(r - other.r, i - other.i);
    }

    public Complex multiply(Complex other) {
        return new Complex(r * other.r - i * other.i, i * other.r + r * other.i);
    }

    public Complex divine(Complex other) {

        double v = other.r * other.r + other.i * other.i;
        final double nr = (r * other.r + i * other.i) / v;
        final double ni = (i * other.r - r * other.i) / v;

        return new Complex(nr, ni);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Complex complex = (Complex) o;

        if (Double.compare(complex.i, i) != 0) return false;
        if (Double.compare(complex.r, r) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(r);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(i);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "r=" + r +
                ", i=" + i +
                '}';
    }
}
