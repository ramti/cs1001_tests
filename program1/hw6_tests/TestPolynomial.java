import il.ac.tau.cs.sw1.hw6.Polynomial;
import org.junit.Assert;
import org.junit.Test;

public class TestPolynomial {
    private static final double epsilon = 0.01;

    public void checkPolynomialEquals(Polynomial polynomial, double[] coeff) {
        Assert.assertEquals(coeff.length - 1, polynomial.getDegree());
        for (int i = 0; i < coeff.length; i++)
            Assert.assertEquals(coeff[i], polynomial.getCoefficient(i), epsilon);
    }

    @Test
    public void testPolynomial() {
        Polynomial zeroPolynomial = new Polynomial();
        checkPolynomialEquals(zeroPolynomial, new double[]{0});

        Polynomial polynomial1 = new Polynomial(new double[]{1, 0, 3});
        checkPolynomialEquals(polynomial1, new double[]{1, 0, 3});

        Polynomial polynomial2 = new Polynomial(new double[]{1, 0, 0});
        checkPolynomialEquals(polynomial2, new double[]{1});
    }

    @Test
    public void testAdds() {
        Polynomial polynomial1 = new Polynomial(new double[]{1, 0, 3});
        Polynomial polynomial2 = new Polynomial(new double[]{10, 5});
        Polynomial polynomial3 = new Polynomial(new double[]{0});
        Polynomial polynomial4 = new Polynomial(new double[]{-1, 0, 5, 2});
        Polynomial polynomial5 = new Polynomial(new double[]{-1, 0, -3});

        checkPolynomialEquals(polynomial1.adds(polynomial2), new double[]{11, 5, 3});
        checkPolynomialEquals(polynomial2.adds(polynomial1), new double[]{11, 5, 3});
        checkPolynomialEquals(polynomial3.adds(polynomial2), new double[]{10, 5});
        checkPolynomialEquals(polynomial1.adds(polynomial4), new double[]{0, 0, 8, 2});
        checkPolynomialEquals(polynomial1.adds(polynomial5), new double[]{0});
    }

    @Test
    public void testMultiply() {
        Polynomial polynomial = new Polynomial(new double[]{1, 0, 3});
        checkPolynomialEquals(polynomial.multiply(5), new double[]{5, 0, 15});
        checkPolynomialEquals(polynomial.multiply(0), new double[]{0});
    }

    @Test
    public void testGetCoefficient() {
        Polynomial polynomial = new Polynomial(new double[]{1, 0, 3});
        Assert.assertEquals(1, polynomial.getCoefficient(0), epsilon);
        Assert.assertEquals(0, polynomial.getCoefficient(1), epsilon);
        Assert.assertEquals(3, polynomial.getCoefficient(2), epsilon);
        Assert.assertEquals(0, polynomial.getCoefficient(3), epsilon);
    }

    @Test
    public void testSetCoefficient() {
        Polynomial polynomial = new Polynomial(new double[]{1, 0, 3});
        polynomial.setCoefficient(0, 0);
        checkPolynomialEquals(polynomial, new double[]{0, 0, 3});
        polynomial.setCoefficient(4, 8);
        checkPolynomialEquals(polynomial, new double[]{0, 0, 3, 0, 8});
        polynomial.setCoefficient(4, 0);
        checkPolynomialEquals(polynomial, new double[]{0, 0, 3});
        polynomial.setCoefficient(2, 0);
        checkPolynomialEquals(polynomial, new double[]{0});
    }

    @Test
    public void testDerivation() {
        Polynomial polynomial = new Polynomial(new double[]{1, 0, 0, 8, 5}); // 1 + 0*x + 0*x^2 + 8*x^3 + 5*x^4
        Polynomial firstDeriv = polynomial.getFirstDerivation();
        checkPolynomialEquals(firstDeriv, new double[]{0, 0, 24, 20}); // 0 + 0*x + 24*x^2 + 20*x^3
        Polynomial secondDeriv = firstDeriv.getFirstDerivation();
        checkPolynomialEquals(secondDeriv, new double[]{0, 48, 60}); // 0 + 48*x + 60*x^2
        Polynomial thirdDeriv = secondDeriv.getFirstDerivation();
        checkPolynomialEquals(thirdDeriv, new double[]{48, 120}); // 48 + 120*x
        Polynomial fourthDeriv = thirdDeriv.getFirstDerivation();
        checkPolynomialEquals(fourthDeriv, new double[]{120}); // 120
        Polynomial fifthDeriv = fourthDeriv.getFirstDerivation();
        checkPolynomialEquals(fifthDeriv, new double[]{0}); // 0
        checkPolynomialEquals(fifthDeriv.getFirstDerivation(), new double[]{0}); // 0
    }

    @Test
    public void testComputePolynomial() {
        Polynomial polynomial = new Polynomial(new double[]{1, 0, 0, 8, 5}); // 1 + 0*x + 0*x^2 + 8*x^3 + 5*x^4
        Assert.assertEquals(1, polynomial.computePolynomial(0), epsilon);
        Assert.assertEquals(14, polynomial.computePolynomial(1), epsilon);
        Assert.assertEquals(-2, polynomial.computePolynomial(-1), epsilon);
        Assert.assertEquals(145, polynomial.computePolynomial(2), epsilon);

        Polynomial zeroPolynomial = new Polynomial();
        Assert.assertEquals(0, zeroPolynomial.computePolynomial(0), epsilon);
        Assert.assertEquals(0, zeroPolynomial.computePolynomial(5), epsilon);
    }

    @Test
    public void testIsExterma() {
        Polynomial zeroPolynomial = new Polynomial();
        Assert.assertFalse(zeroPolynomial.isExtrema(0));

        Polynomial polynomial1 = new Polynomial(new double[]{-4, 0, 1}); // x^2 - 4
        Assert.assertTrue(polynomial1.isExtrema(0));
        Assert.assertFalse(polynomial1.isExtrema(2));

        Polynomial polynomial2 = new Polynomial(new double[]{0, 0, 0, 1}); // x^3
        Assert.assertFalse(polynomial2.isExtrema(0));

        Polynomial polynomial3 = new Polynomial(new double[]{0, 2, -1}); // -x^2 + 2x
        Assert.assertTrue(polynomial3.isExtrema(1));
    }
}
