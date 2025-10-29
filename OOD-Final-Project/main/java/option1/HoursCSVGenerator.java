package option1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * CSV file generator that contains 6 columns (sections), one for each hour in the day in ascending
 * order. Each section contains the top 10 busiest lifts for that hour.
 */
public class HoursCSVGenerator extends ACSVGenerator {

  private final Map<Integer, Map<Integer, Integer>> hourLiftData;
  private static final Integer OPENING_HOUR = 9;
  private static final Integer CLOSING_HOUR = 14;
  private static final Integer NUMBER_OF_LIFTS_RANKED = 10;

  /**
   * Constructor for the hourly ski data csv generator
   *
   * @param outputFileName - String, the output file name
   * @param hourLiftData   - Map<Integer, Map<Integer, Integer>>, the hourly lift data
   */
  public HoursCSVGenerator(String outputFileName,
      Map<Integer, Map<Integer, Integer>> hourLiftData) {
    super(outputFileName);
    this.hourLiftData = hourLiftData;
  }

  @Override
  public void generate() throws IOException {
    List<String> records = new ArrayList<>();
    addHeader(records);
    for (int rank = 0; rank < NUMBER_OF_LIFTS_RANKED; rank++) {
      StringBuilder line = new StringBuilder();
      for (int hour = OPENING_HOUR; hour <= CLOSING_HOUR; hour++) {
        Map<Integer, Integer> sortedMap = hourLiftData.getOrDefault(hour, new HashMap<>());
        List<Map.Entry<Integer, Integer>> list = sortedMap.entrySet()
            .stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).toList();
        if (rank < list.size()) {
          Map.Entry<Integer, Integer> entry = list.get(rank);
          line.append(entry.getKey()).append(" ").append(entry.getValue());
        } else {
          line.append("-");
        }
        if (hour != CLOSING_HOUR) {
          line.append(",");
        }
      }
      records.add(line.toString());
    }
    writeToFile(outputFileName, records);
  }

  @Override
  protected void addHeader(List<String> records) {
    String header = Arrays.stream(new int[]{9, 10, 11, 12, 13, 14}).mapToObj(h -> "Hour " + h)
        .collect(
            Collectors.joining(","));
    records.add(header);
  }
}
