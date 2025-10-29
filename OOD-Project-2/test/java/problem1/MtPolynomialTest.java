package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MtPolynomialTest {

  private MtPolynomial testPolynomial;

  @Test
  void getDegree() {
    assertEquals(0, testPolynomial.getDegree());
  }

  @Test
  void getCoefficient() {
    assertEquals(0, testPolynomial.getCoefficient(0));
  }

  @Test
  void addTerm() {
    testPolynomial.addTerm(1, 1);
    assertEquals(1, testPolynomial.getDegree());
  }

  @Test
  void compare() {
    assertFalse(testPolynomial.compare(new MtPolynomial()));
  }

  @Test
  void testToString() {
    assertEquals("Empty Polynomial", testPolynomial.toString());
  }
}