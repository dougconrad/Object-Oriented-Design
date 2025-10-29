package assignment5;

/** class AccessibleSeat represents a singular accessible seat within a row
 *
 * Each seat has a name and can be reserved
 */
public class AccessibleSeat extends Seat {

  /** Constructor for accessible seat
   *
   * @param name String, the name of the seat
   */
  public AccessibleSeat(String name) {
    super(name);
  }

  /** a string representation of an accessible seat
   * @return String, "X" if it is reserved, "=" if not
   */
  @Override
  public String toString() {
    return isReserved() ? "X" : "=";
  }


}
