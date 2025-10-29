package assignment5;

/** class Seat represents a singular seat within a row
 *
 * Each seat has a name and can be reserved
 */
public class Seat {

  private final String name;
  private String reservedFor;

  /** Constructor for seat
   *
   * @param name String, the name of the seat
   */
  public Seat(String name) {
    this.name = name;
    this.reservedFor = null;
  }

  /** gets the name of the seat
   * @return String, a seats name
   */
  public String getName() {
    return name;
  }

  /** gets the name of the person who reserved a seat
   * @return String, name of the reserver
   */
  public String getReservedFor() {
    return reservedFor;
  }

  /** checks if a seat is reserved
   * @return boolean, true if the seat is reserved, false if not
   */
  public boolean isReserved() {
    return reservedFor != null;
  }

  /** reserves a seat
   * @param name String, the name of the person to reserve a seat
   */
  public void reserve(String name) {
    reservedFor = name;
  }

  /** a string representation of a seat
   * @return String, "X" if it is reserved, "_" if not
   */
  @Override
  public String toString() {
    return isReserved() ? "X" : "_";
  }

}
