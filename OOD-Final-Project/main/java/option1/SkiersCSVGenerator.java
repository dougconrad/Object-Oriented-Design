package option1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * CSV file generator contains the skiers with the top 100 vertical totals in descending order
 */
public class SkiersCSVGenerator extends ACSVGenerator {

  private final Map<Integer, Integer> skierVertical;
  private static final Integer NUMBER_OF_SKIERS_RANKED = 100;

  /**
   * Constructor for the skier ski data csv generator
   *
   * @param outputFileName - String, the output file name
   * @param skierVertical  - Map<Integer, Integer>, the skier vertical
   */
  public SkiersCSVGenerator(String outputFileName, Map<Integer, Integer> skierVertical) {
    super(outputFileName);
    this.skierVertical = skierVertical;
  }

  @Override
  public void generate() throws IOException {
    List<String> records = new ArrayList<>();
    addHeader(records);
    skierVertical.entrySet().stream()
        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
        .limit(NUMBER_OF_SKIERS_RANKED)
        .forEach(entry -> records.add(entry.getKey() + "," + entry.getValue()));

    writeToFile(outputFileName, records);
  }

  @Override
  protected void addHeader(List<String> records) {
    records.add("SkierID,Vertical Distance");
  }
}
