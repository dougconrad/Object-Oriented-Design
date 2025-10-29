package option1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads the raw ski data
 */
public class SkiDataReader {

  /**
   * Reads the raw ski data
   *
   * @param filePath - String, the file path
   * @return - List<LiftRecord>, an easily interpretable list of ski data
   */
  public List<LiftRecord> read(String filePath) {
    List<LiftRecord> records = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      br.readLine();
      String line;
      while ((line = br.readLine()) != null) {
        records.add(new LiftRecord(line));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return records;
  }

}
