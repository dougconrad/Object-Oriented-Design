package assignment5;

import java.util.ArrayList;

/** Class row represents a row in a theater, containing a list of Seats
 * Each row has a row number and can be marked as wheelchair accessible
 *
 */
public class Row extends ArrayList<Seat> {

  private final int rowNumber;
  private final boolean wheelChairAccessible;

  /** Constructor for class row
   * @param rowNumber - int, the number of a row
   * @param numSeats - int, the number of seats in a row
   * @param wheelChairAccessible - boolean, whether a row is wheelchair accessible
   */
  public Row(int rowNumber, int numSeats, boolean wheelChairAccessible) {
    super(numSeats);
    this.rowNumber = rowNumber;
    this.wheelChairAccessible = wheelChairAccessible;
    for (int i = 0; i < numSeats; i++) {
      if (wheelChairAccessible) {
        this.add(new AccessibleSeat(String.valueOf((char) ('A' + i))));
      } else this.add(new Seat(String.valueOf((char) ('A' + i))));
    }
  }

  /** gets the row number
   * @return int - the row number
   */
  public int getRowNumber() {
    return rowNumber;
  }

  /** checks if a row is wheelchair accessible
   * @return boolean - true if it is accessible, false if not
   */
  public boolean isWheelChairAccessible() {
    return wheelChairAccessible;
  }

  /** a string representation of a row
   * @return String - a row that contains seats, represented as a string
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(rowNumber).append("  ");
    for (Seat seat : this) {
      sb.append(seat).append(" ");
    }
    return sb.toString().trim();
  }
}
