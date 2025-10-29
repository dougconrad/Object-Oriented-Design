package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsPolynomialTest {

  private ConsPolynomial testPolynomial;
  private Term head;
  private MtPolynomial testPolynomial2;

  @BeforeEach
  void setUp() {
    head = new Term(1, 1);
    testPolynomial = new ConsPolynomial(head, testPolynomial2);

  }

  @Test
  void getDegree() {
    assertEquals(1, testPolynomial.getDegree());
  }

  @Test
  void getCoefficient() {
    assertEquals(1, testPolynomial.getCoefficient(1));
  }

  @Test
  void addTerm() {
    testPolynomial.addTerm(1, 1);
    assertEquals(1, testPolynomial.getDegree());
  }

  @Test
  void compare() {
    assertTrue(testPolynomial.compare(testPolynomial));
  }
}