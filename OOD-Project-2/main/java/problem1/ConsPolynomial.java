package problem1;


import java.util.Objects;

/**
 * Class for a non-empty polynomial
 */
public class ConsPolynomial implements IPolynomial {

  private Term head;
  private IPolynomial rest;

  /**
   * Constructor for class Polynomial
   *
   * @param head - Term, first term in the polynomial
   * @param rest - IPolynomial, rest of the terms in the polynomial
   */
  public ConsPolynomial(Term head, IPolynomial rest) {
    this.head = head;
    this.rest = rest;
  }

  @Override
  public int getDegree() {
    if (rest == null) {
      return head.getPower();
    }
    return Math.max(head.getPower(), rest.getDegree());
  }

  @Override
  public int getCoefficient(int power) {
    if (head.getPower() == power) {
      return head.getCoefficient();
    }
    return rest.getCoefficient(power);
  }

  @Override
  public IPolynomial addTerm(int coefficient, int power) {
    if (power < 0) {
      throw new IllegalArgumentException("Power must be non-negative");
    }
    if (coefficient == 0) {
      return this;
    }
    if (head == null) {
      head = new Term(coefficient, power);
      return this;
    }
    Term current = head;
    Term prev = null;
    while (current != null && current.power > power) {
      prev = current;
      current = current.next;
    }
    if (current != null && current.power == power) {
      current.coefficient += coefficient;
      if (current.coefficient == 0) {
        if (prev == null) {
          head = head.next;
        } else {
          prev.next = current.next;
        }
      }
    } else {
      Term newTerm = new Term(coefficient, power);
      if (prev == null) {
        newTerm.next = head;
      }
    }
    return this;
  }

  @Override
  public Boolean compare(IPolynomial polynomial) {
    if (polynomial == null) {
      return false;
    }
    Term term1 = this.head;
    Term term2 = ((ConsPolynomial) polynomial).head;
    while (term1 != null && term2 != null) {
      if (!term1.equals(term2)) {
        return false;
      }
      term1 = term1.next;
      term2 = term2.next;
    }
    return term1 == null && term2 == null;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsPolynomial that = (ConsPolynomial) o;
    return Objects.equals(head, that.head);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(head);
  }
}
