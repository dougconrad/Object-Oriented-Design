package problem1;

public class Term {

  public int coefficient;
  public int power;
  public Term next;

  /**
   * Constructor for class Term
   *
   * @param coefficient - int, coefficient of the term
   * @param power       - int, power of the term
   */
  public Term(int coefficient, int power) {
    this.coefficient = coefficient;
    this.power = power;
    this.next = null;
  }

  public int getCoefficient() {
    return coefficient;
  }

  public int getPower() {
    return power;
  }
}
