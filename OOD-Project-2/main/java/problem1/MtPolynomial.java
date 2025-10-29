package problem1;

/**
 * Class for an empty polynomial
 */
public class MtPolynomial implements IPolynomial {


  @Override
  public int getDegree() {
    return 0;
  }

  @Override
  public int getCoefficient(int power) {
    return 0;
  }

  @Override
  public IPolynomial addTerm(int coefficient, int power) {
    if (coefficient == 0) {
      return this;
    }
    return new ConsPolynomial(new Term(coefficient, power), this);
  }

  @Override
  public Boolean compare(IPolynomial polynomial) {
    return false;
  }

  @Override
  public String toString() {
    return "Empty Polynomial";
  }
}
