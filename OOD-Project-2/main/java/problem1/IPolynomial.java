package problem1;

public interface IPolynomial {

  /**
   * Gives degree of the polynomial
   *
   * @return - int, degree of the polynomial
   */
  int getDegree();

  /**
   * Gives coefficient of term with given power
   *
   * @param power - int, power of a term
   * @return - int, coefficient of term
   */
  int getCoefficient(int power);

  /**
   * Adds a term to the polynomial
   *
   * @param coefficient - coefficient of the term
   * @param power       - power of the term
   */
  IPolynomial addTerm(int coefficient, int power);

  /**
   * Compares two polynomials
   *
   * @param polynomial - Polynomial, polynomial being compared
   * @return - Boolean, true if equal, false if not
   */
  Boolean compare(IPolynomial polynomial);


}
