package option1;

import static java.lang.Integer.parseInt;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Processor class for the ski data application
 */
public class SkiDataProcessor {

  private static final String INPUT_FILE = "skier_lift_data.csv";
  private static final String SKIERS_FILE = "skiers.csv";
  private static final String LIFTS_FILE = "lifts.csv";
  private static final String HOURS_FILE = "hours.csv";
  private static final Integer MINUTES_IN_HOUR = 60;
  private static final Integer OPENING_HOUR = 9;
  private static final Integer SHORT_LIFT_VERTICAL = 200;
  private static final Integer HIGH_LIFT_VERTICAL = 500;


  public static void main(String[] args) throws IOException {
    SkiDataReader dataReader = new SkiDataReader();
    List<LiftRecord> records = dataReader.read(INPUT_FILE);
    Map<Integer, Integer> skierVertical = new HashMap<>();
    Map<Integer, Integer> liftData = new HashMap<>();
    Map<Integer, Map<Integer, Integer>> hourLiftData = new HashMap<>();
    for (LiftRecord record : records) {
      int liftID = parseInt(record.liftID);
      int vertical = getLiftVertical(liftID);
      int skierID = parseInt(record.skierID);
      skierVertical.merge(skierID, vertical, Integer::sum);
      liftData.merge(liftID, 1, Integer::sum);
      int hour = (parseInt(record.timestamp) / MINUTES_IN_HOUR) + OPENING_HOUR;
      hourLiftData.computeIfAbsent(hour, k -> new HashMap<>()).merge(liftID, 1, Integer::sum);
    }

    ACSVGenerator skiersFile = new SkiersCSVGenerator(SKIERS_FILE, skierVertical);
    skiersFile.generate();
    ACSVGenerator hoursFile = new HoursCSVGenerator(HOURS_FILE, hourLiftData);
    hoursFile.generate();
    ACSVGenerator liftsFile = new LiftsCSVGenerator(LIFTS_FILE, liftData);
    liftsFile.generate();

  }

  /**
   * Gets the vertical distance of a lift given its number
   *
   * @param liftID - int, lift ID
   * @return - int, vertical distance of given lift
   */
  private static int getLiftVertical(int liftID) {
    return (liftID >= 1 && liftID <= 20) ? SHORT_LIFT_VERTICAL : HIGH_LIFT_VERTICAL;
  }

}
