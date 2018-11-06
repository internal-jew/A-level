import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import hw_15.Fraction;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FractionTest {
    private Fraction fractionInputA;
    private Fraction fractionInputB;
    private double doubleValue;
    private Fraction fractionExpectedSumm;
    private Fraction fractionExpectedMulti;
    private Fraction fractionExpectedDivide;
    private boolean isSameFraction;


    public FractionTest(Fraction fractionInputA, Fraction fractionInputB, double doubleValue,
                        Fraction fractionExpectedSumm, Fraction fractionExpectedMulti, Fraction fractionExpectedDivide, boolean isSameFraction) {
        this.fractionInputA = fractionInputA;
        this.fractionInputB = fractionInputB;
        this.doubleValue = doubleValue;
        this.fractionExpectedSumm = fractionExpectedSumm;
        this.fractionExpectedMulti = fractionExpectedMulti;
        this.fractionExpectedDivide = fractionExpectedDivide;
        this.isSameFraction = isSameFraction;
    }

    @Parameterized.Parameters(name = "{index}: sumOf({0}+{1})={3}, multiOf({0}*{2})={4}, divideOf({0}/{2})={5}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Fraction(3, 4), new Fraction(3, 4), 0.1, new Fraction(3, 2),
                        new Fraction(3, 40), new Fraction(15, 2), true},
                {new Fraction(1, 2), new Fraction(7, 8), 0.2, new Fraction(11, 8),
                        new Fraction(1, 10), new Fraction(5, 2), false},
                {new Fraction(1, 3), new Fraction(1, 35), 0.25, new Fraction(38, 105),
                        new Fraction(1, 12), new Fraction(4, 3), false},
                {new Fraction(17, 52), new Fraction(7, 3), 0, new Fraction(415, 156),
                        new Fraction(0, 0), new Fraction(0, 0), false},
                {new Fraction(1, 2), new Fraction(-1, 3), -2.3, new Fraction(1, 6),
                        new Fraction(-23, 20), new Fraction(-5, 23), false},

        });
    }


    @Test
    public void paramTest() {


        assertEquals(isSameFraction, fractionInputA.equals(fractionInputB));
        assertEquals(fractionExpectedSumm, fractionInputA.sum(fractionInputB));
        assertEquals(fractionExpectedMulti, fractionInputA.mult(doubleValue));
        assertEquals(fractionExpectedDivide, fractionInputA.divide(doubleValue));


    }

}