package option1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * CSV file generator contains a row for every lift. In each row, there is information about the
 * number of rides on that lift in the given day. The file is organized in ascending order of
 * LiftID.
 */
public class LiftsCSVGenerator extends ACSVGenerator {

  private final Map<Integer, Integer> liftData;
  private static final Integer NUMBER_OF_LIFTS = 40;

  /**
   * Constructor for the lift ski data csv generator
   *
   * @param outputFileName - String, the output file name
   * @param liftData       - Map<Integer, Integer>, the lift data
   */
  public LiftsCSVGenerator(String outputFileName, Map<Integer, Integer> liftData) {
    super(outputFileName);
    this.liftData = liftData;
  }

  @Override
  public void generate() throws IOException {
    List<String> records = new ArrayList<>();
    addHeader(records);
    for (int liftID = 1; liftID <= NUMBER_OF_LIFTS; liftID++) {
      records.add(liftID + "," + liftData.getOrDefault(liftID, 0));
    }
    writeToFile(outputFileName, records);
  }

  @Override
  protected void addHeader(List<String> records) {
    records.add("LiftID, Number of Rides");
  }
}
