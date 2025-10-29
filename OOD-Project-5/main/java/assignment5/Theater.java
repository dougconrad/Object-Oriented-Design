package assignment5;

import java.util.ArrayList;
import java.util.List;

/** Class theater represents a theater with rows of seats, and some wheelchair accessible rows
 *
 * A theater contains a name, a list of rows, and a list of row numbers that are accessible with a wheelchair
 */
public class Theater {

  private final String name;
  private final List<Row> rows;
  private final List<Integer> accessibleRows;

  /** Constructor for Theater class
   *
   * @param name - String, the name of the theater
   * @param numRows- int, number of rows in the theater
   * @param numSeatsPerRow - int, number of seats per row
   * @param accessibleRows - List<Integer>, a list of row numbers that are wheelchair accessible
   * @throws IllegalArgumentException if the list of accessible rows is null or empty,
   * because there has to be at least one accessible row.
   */
  public Theater(String name, int numRows, int numSeatsPerRow, List<Integer> accessibleRows) {
    if (accessibleRows == null || accessibleRows.isEmpty()) {
      throw new IllegalArgumentException("There must be at least one accessible row.");
    }
    this.name = name;
    this.rows = new ArrayList<>();
    this.accessibleRows = new ArrayList<>(accessibleRows);
    for (int i = 1; i <= numRows; i++) {
      boolean isAccesible = accessibleRows.contains(i);
      rows.add(new Row(i, numSeatsPerRow, isAccesible));
    }
  }

  /** gets the Theater's name
   * @return String, the name of the Theater
   */
  public String getName() {
    return name;
  }

  /** Gets the list of rows in a theater
   * @return List<Row>, the list of rows
   */
  public List<Row> getRows() {
    return rows;
  }


  /**
   * Gets accessible rows.
   *
   * @return List<Integer>, the accessible rows
   */
  public List<Integer> getAccessibleRows() {
    return accessibleRows;
  }

  /**
   * shows the seating arrangement in the theater
   */
  public void show() {
    for (Row row : rows) {
      System.out.println(row);
    }
  }

  /** gets the number of the center row in the theater
   * @return int, the row number of the center row
   */
  public int getCenterRowNumber() {
    return (rows.size() + 1) / 2;
  }
}
