package assignment5;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * class ReservationsService handles the user interface for the reservation service.
 * Users can interact with the service through the command line to reserve seats.
 */
public class ReservationsService {

  private static final int EXPECTED_RESERVE_INPUT_LENGTH = 2;

  /** Runs the Reservation service by prompting users
   *
   * @param theater Theater - the Theater where the reservation is made
   */
  public static void run(Theater theater) {
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.println("What would you like to do?");
      String commandLine = input.nextLine().trim();
      if (commandLine.equalsIgnoreCase("done")) {
        System.out.println("Have a nice day!");
        break;
      } else if (commandLine.equalsIgnoreCase("show")) {
        theater.show();
      } else if (commandLine.toLowerCase().startsWith("reserve")) {
        handleReservation(commandLine, theater, input);
      } else {
        System.out.println("Invalid command. Try again.");
      }
    }
  }

  /**
   *  validates inputs and handles commands to reserve seats
   *
   * @param command String - input containing the reserve command
   * @param theater Theater - the theater where the reservation is made
   * @param input Scanner - the scanner to read inputs
   */
  private static void handleReservation(String command, Theater theater, Scanner input) {
    String[] reserveCommand = command.split(" ");
    if (reserveCommand.length != EXPECTED_RESERVE_INPUT_LENGTH) {
      System.out.println("Invalid reserve command.");
      return;
    }
    try {
      int count = Integer.parseInt(reserveCommand[1]);
      if (count <= 0) {
        System.out.println("Number of seats must be positive.");
        return;
      }
      System.out.println("What's your name?");
      String name = input.nextLine().trim();
      System.out.println("Do you need wheelchair accessible seats? (yes/no)");
      String wheelchairAccessible = input.nextLine().trim();
      if (wheelchairAccessible.equalsIgnoreCase("yes")) {
        if (!tryReserveAccessible(theater, name, count)) {
          System.out.println("Sorry, we don't have that many seats together for you.");
        }
      } else {
        if (!tryReserve(theater, name, count)) {
          if (!tryReserveAccessible(theater, name, count)) {
            System.out.println("Sorry, we don't have that many seats together for you.");
          }
          System.out.println("Sorry, we don't have that many seats together for you.");
        }
      }
    } catch (NumberFormatException e) {
      System.out.println("Invalid number format for seats.");
    }
  }

  /**
   * attempts to reserve seats for a user in the best row available
   *
   * @param theater - Theater, the theater to reserve the seats in
   * @param name - String, the name of the person reserving the seats
   * @param count - int, the number of seats to reserve
   * @return - boolean, true if the reservation was successful, false if not
   */
  static boolean tryReserve(Theater theater, String name, int count) {
    int center = theater.getCenterRowNumber();
    List<Row> sortedRows = theater.getRows().stream()
        .sorted(Comparator.comparingInt(r -> Math.abs(r.getRowNumber() - center))).toList();
    for (Row row : sortedRows) {
      if (!row.isWheelChairAccessible()) {
        if (tryReserveConsecutiveSeats(row, name, count)) {
          System.out.println(
              "I’ve reserved " + count + " seats for you at the " + theater.getName() + " in row "
                  + row.getRowNumber() + ", " + name + ".");
          return true;
        }
      }
    }
    return false;
  }

  /**
   * attempts to reserve seats for a user in the best accessible row available
   *
   * @param theater - Theater, the theater to reserve the seats in
   * @param name - String, the name of the person reserving the seats
   * @param count - int, the number of seats to reserve
   * @return - boolean, true if the reservation was successful, false if not
   */
  static boolean tryReserveAccessible(Theater theater, String name, int count) {
    int center = theater.getCenterRowNumber();
    List<Row> sortedRows = theater.getRows().stream()
        .sorted(Comparator.comparingInt(r -> Math.abs(r.getRowNumber() - center))).toList();
    for (Row row : sortedRows) {
      if (row.isWheelChairAccessible()) {
        if (tryReserveConsecutiveSeats(row, name, count)) {
          System.out.println(
              "I’ve reserved " + count + " seats for you at the " + theater.getName() + " in row "
                  + row.getRowNumber() + ", " + name + ".");
          return true;
        }
      }
    }
    return false;
  }

  /**
   * tries to reserve a row of consecutive seats for a user
   *
   * @param row - Row, the row to reserve seats
   * @param name - String, the name of the person who is reserving seats
   * @param count - int, the number of seats to reserve
   * @return - boolean, true if the seats were reserved, false if not
   */
  public static boolean tryReserveConsecutiveSeats(Row row, String name, int count) {
    int consecutive = 0;
    for (int i = 0; i < row.size(); i++) {
      if (!row.get(i).isReserved()) {
        consecutive++;
        if (consecutive == count) {
          for (int j = i - count + 1; j <= i; j++) {
            row.get(j).reserve(name);
          }
          return true;
        }
      } else {
        consecutive = 0;
      }
    }
    return false;
  }
}
