package assignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Class CSVReader stores information about the CSV reader A utility class for reading customer data
 * from a CSV file. Each line in the file is parsed into a {@link Customer} object, using the
 * headers from the first line of the CSV.
 * <p>
 * This parser supports quoted fields that may contain commas.
 */
public class CSVReader {

  /**
   * Private constructor to prevent instantiation.
   */
  private CSVReader() {
  }

  /**
   * Reads all customers from the specified CSV file.
   *
   * @param filePath - String, the path to the CSV file
   * @return - List<Customer>, a list of {@link Customer} objects
   * @throws IOException if an I/O error occurs
   */
  public static List<Customer> readAll(String filePath) throws IOException {
    List<Customer> customers = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String headerLine = reader.readLine();
      if (headerLine == null) {
        return customers;
      }
      List<String> headers = parseLine(headerLine);
      String line;
      while ((line = reader.readLine()) != null) {
        List<String> values = parseLine(line);
        Map<String, String> data = new HashMap<>();
        for (int i = 0; i < headers.size(); i++) {
          String key = headers.get(i);
          String value = i < values.size() ? values.get(i).trim() : "";
          data.put(key, value);
        }
        customers.add(new Customer(data));
      }
    }
    return customers;
  }

  /**
   * Parses a single line of CSV, respecting quoted fields and commas within quotes.
   *
   * @param line - String, the CSV line, as String
   * @return - List<String>, a list of values in that line
   */
  private static List<String> parseLine(String line) {
    List<String> fields = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean inQuotes = false;
    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i);
      if (c == '"') {
        if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '"') {
          sb.append('"');
          i++; // skip the second quote
        } else {
          inQuotes = !inQuotes;
        }
      } else if (c == ',' && !inQuotes) {
        fields.add(sb.toString());
        sb.setLength(0);
      } else {
        sb.append(c);
      }
    }
    fields.add(sb.toString()); // add last field
    return fields;
  }
}
