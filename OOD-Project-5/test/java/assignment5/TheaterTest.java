package assignment5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TheaterTest {

  @Test
  void testConstructor_withValidAccessibleRows() {
    List<Integer> accessible = Arrays.asList(2, 4);
    Theater theater = new Theater("Roxy", 5, 10, accessible);

    assertEquals("Roxy", theater.getName());
    assertEquals(5, theater.getRows().size());

    // Check accessibility flags
    assertFalse(theater.getRows().get(0).isWheelChairAccessible()); // row 1
    assertTrue(theater.getRows().get(1).isWheelChairAccessible());  // row 2
    assertFalse(theater.getRows().get(2).isWheelChairAccessible()); // row 3
    assertTrue(theater.getRows().get(3).isWheelChairAccessible());  // row 4
    assertFalse(theater.getRows().get(4).isWheelChairAccessible()); // row 5
  }

  @Test
  void testConstructor_withNoAccessibleRows_throwsException() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
        new Theater("NoAccess", 3, 5, List.of())
    );
    assertEquals("There must be at least one accessible row.", exception.getMessage());
  }

  @Test
  void testGetCenterRowNumber_oddNumberOfRows() {
    Theater theater = new Theater("OddCenter", 7, 5, List.of(1));
    assertEquals(4, theater.getCenterRowNumber());  // (7 + 1) / 2 = 4
  }

  @Test
  void testGetCenterRowNumber_evenNumberOfRows() {
    Theater theater = new Theater("EvenCenter", 8, 5, List.of(1));
    assertEquals(4, theater.getCenterRowNumber());  // (8 + 1) / 2 = 4 (middle-biased)
  }

  @Test
  void testShowMethod_printsAllRows() {
    Theater theater = new Theater("Visual", 2, 3, List.of(2));
    // Reserve 2 seats to simulate a realistic scenario
    theater.getRows().get(0).get(0).reserve("Alex");
    theater.getRows().get(1).get(1).reserve("Zoe");

    assertDoesNotThrow(theater::show);
  }
}
