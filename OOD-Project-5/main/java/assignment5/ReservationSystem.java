package assignment5;

import java.util.Arrays;

/** class ReservationSystem creates a theater instance for ReservationService to use
 *
 * Creates a Theater called broadway with 15 rows and 10 seats/row, and 8 accessible rows
 */
public class ReservationSystem {

  /**
   * main method to start the system
   *
   * @param args - String[], the arguments for the command line
   */
  public static void main(String[] args) {
    ReservationsService.run(new Theater("Broadway", 15, 10, Arrays.asList(8)));
  }
}
