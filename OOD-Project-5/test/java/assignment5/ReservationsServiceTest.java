package assignment5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class ReservationsServiceTest {

  private ByteArrayOutputStream outputStream;
  private PrintStream originalOut;
  private Theater theater;

  @BeforeEach
  void setUp() {
    outputStream = new ByteArrayOutputStream();
    originalOut = System.out;
    System.setOut(new PrintStream(outputStream));
    List<Integer> accessibleRows = List.of(2);
    theater = new Theater("Test Theater", 3, 4, accessibleRows);
  }

  @AfterEach
  void tearDown() {
    System.setOut(originalOut);
  }

  @Test
  void testRunWithDoneCommand() {
    String input = "done\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    ReservationsService.run(theater);
    String output = outputStream.toString();
    assertTrue(output.contains("Have a nice day!"));
  }

  @Test
  void testRunWithShowCommand() {
    String input = "show\ndone\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    ReservationsService.run(theater);
    String output = outputStream.toString();
    assertTrue(output.contains("Have a nice day!"));
  }

  @Test
  void testRunWithInvalidCommand() {
    String input = "invalid\ndone\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    ReservationsService.run(theater);
    String output = outputStream.toString();
    assertTrue(output.contains("Invalid command. Try again."));
  }

  @Test
  void testInvalidReserveCommand() {
    String input = "reserve\ndone\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    ReservationsService.run(theater);
    String output = outputStream.toString();
    assertTrue(output.contains("Invalid reserve command."));
  }

  @Test
  void testInvalidNumberFormat() {
    String input = "reserve abc\ndone\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    ReservationsService.run(theater);
    String output = outputStream.toString();
    assertTrue(output.contains("Invalid number format for seats."));
  }

  @Test
  void testNegativeSeats() {
    String input = "reserve -1\ndone\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    ReservationsService.run(theater);
    String output = outputStream.toString();
    assertTrue(output.contains("Number of seats must be positive."));
  }

  @Test
  void testZeroSeats() {
    String input = "reserve 0\ndone\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    ReservationsService.run(theater);
    String output = outputStream.toString();
    assertTrue(output.contains("Number of seats must be positive."));
  }

  @Test
  void testTryReserveConsecutiveSeatsSuccess() {
    Row row = theater.getRows().get(0);
    boolean result = ReservationsService.tryReserveConsecutiveSeats(row, "Test User", 2);
    assertTrue(result);
    assertTrue(row.get(0).isReserved());
    assertTrue(row.get(1).isReserved());
  }

  @Test
  void testTryReserveConsecutiveSeatsPartiallyReserved() {
    Row row = theater.getRows().get(0);
    row.get(0).reserve("Someone");
    boolean result = ReservationsService.tryReserveConsecutiveSeats(row, "Test User", 2);
    assertTrue(result);
    assertTrue(row.get(1).isReserved());
    assertTrue(row.get(2).isReserved());
  }

  @Test
  void testTryReserveConsecutiveSeatsNotEnoughSpace() {
    Row row = theater.getRows().get(0);
    row.get(0).reserve("Someone");
    row.get(2).reserve("Someone");
    boolean result = ReservationsService.tryReserveConsecutiveSeats(row, "Test User", 2);
    row.get(1).reserve("Someone");
    row.get(3).reserve("Someone");
    result = ReservationsService.tryReserveConsecutiveSeats(row, "Test User", 2);
    assertFalse(result);
  }

  @Test
  void testTryReserveConsecutiveSeatsAllReserved() {
    Row row = theater.getRows().get(0);
    for (int i = 0; i < row.size(); i++) {
      row.get(i).reserve("Someone");
    }
    boolean result = ReservationsService.tryReserveConsecutiveSeats(row, "Test User", 2);
    assertFalse(result);
  }

  @Test
  void testTryReserveFail() {
    for (Row row : theater.getRows()) {
      if (!row.isWheelChairAccessible()) {
        for (int i = 0; i < row.size(); i++) {
          row.get(i).reserve("Someone");
        }
      }
    }
    boolean result = ReservationsService.tryReserve(theater, "John", 2);
    assertFalse(result);
  }

  @Test
  void testTryReserveAccessibleFail() {
    for (Row row : theater.getRows()) {
      if (row.isWheelChairAccessible()) {
        for (int i = 0; i < row.size(); i++) {
          row.get(i).reserve("Someone");
        }
      }
    }
    boolean result = ReservationsService.tryReserveAccessible(theater, "Jane", 2);
    assertFalse(result);
  }

  @Test
  void testReservationFailsShowsMessage() {
    for (Row row : theater.getRows()) {
      for (int i = 0; i < row.size(); i++) {
        row.get(i).reserve("Someone");
      }
    }
    String input = "reserve 2\nJohn\nno\ndone\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    ReservationsService.run(theater);
    String output = outputStream.toString();
    assertTrue(output.contains("Sorry, we don't have that many seats together for you."));
  }

  @Test
  void testReservationAccessibleFailsShowsMessage() {
    for (Row row : theater.getRows()) {
      if (row.isWheelChairAccessible()) {
        for (int i = 0; i < row.size(); i++) {
          row.get(i).reserve("Someone");
        }
      }
    }
    String input = "reserve 2\nJane\nyes\ndone\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    ReservationsService.run(theater);
    String output = outputStream.toString();
    assertTrue(output.contains("Sorry, we don't have that many seats together for you."));
  }

}