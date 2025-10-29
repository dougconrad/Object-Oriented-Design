package option1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Abstract csv file generator
 */
public abstract class ACSVGenerator {

  protected final String outputFileName;

  /**
   * Constructor for an abstract csv generator
   *
   * @param outputFileName - String, the output file name
   */
  public ACSVGenerator(String outputFileName) {
    this.outputFileName = outputFileName;
  }

  /**
   * Write to file.
   *
   * @param fileName - String, the file name
   * @param records  - List<String>, the records
   * @throws IOException if file cannot be found or read
   */
  protected void writeToFile(String fileName, List<String> records) throws IOException {
    try (PrintWriter writer = new PrintWriter(fileName)) {
      for (String record : records) {
        writer.println(record);
      }
    }
  }

  /**
   * Generates filtered ski data as a csv file.
   *
   * @throws IOException the io exception
   */
  public abstract void generate() throws IOException;

  /**
   * Helper method for generate that adds a header to the csv file.
   *
   * @param records - List<String>, the records
   * @throws IOException the io exception
   */
  protected abstract void addHeader(List<String> records) throws IOException;
}
