package Rational;

import java.util.Objects;

public class Rational implements Comparable<Rational>{
    private int numerator;
    private int denominator;

    public Rational() {
        this.numerator = 0;
        this.denominator = 0;
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    @Override
    public int compareTo(Rational rational) {
        return (numerator*denominator)-(rational.getNumerator()*rational.getDenominator());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Rational other = (Rational) obj;
        return denominator == other.denominator && numerator == other.numerator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator,denominator);
    }
}
