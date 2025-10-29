package assignment4;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CSVReaderTest {

  private Path tempFile;

  @BeforeEach
  public void setup() throws IOException {
    tempFile = Files.createTempFile("test", ".csv");
  }

  @AfterEach
  public void cleanup() throws IOException {
    Files.deleteIfExists(tempFile);
  }

  @Test
  public void testReadSimpleCSV() throws IOException {
    String content = "\"first_name\",\"last_name\",\"email\"\n" +
        "\"Savino\",\"Ventura\",\"vino@example.com\"\n" +
        "\"John\",\"Dunay\",\"john@example.com\"";
    Files.writeString(tempFile, content);

    List<Customer> customers = CSVReader.readAll(tempFile.toString());
    assertEquals(2, customers.size());
    assertEquals("Savino", customers.get(0).get("first_name"));
    assertEquals("vino@example.com", customers.get(1).get("email"));
  }

  @Test
  public void testCSVWithQuotedComma() throws IOException {
    String content = "\"first_name\",\"last_name\"\n" +
        "\"Josephine\",\"R,Darakjy\"";
    Files.writeString(tempFile, content);

    List<Customer> customers = CSVReader.readAll(tempFile.toString());
    assertEquals(1, customers.size());
    assertEquals("R,Darakjy", customers.get(0).get("last_name"));
  }

  @Test
  public void testEmptyFileReturnsEmptyList() throws IOException {
    Files.writeString(tempFile, "");
    List<Customer> customers = CSVReader.readAll(tempFile.toString());
    assertTrue(customers.isEmpty());
  }

  @Test
  public void testLineWithMissingValues() throws IOException {
    String content = "\"first_name\",\"last_name\",\"email\"\n" +
        "\"Tom\",\"Hanks\"";
    Files.writeString(tempFile, content);

    List<Customer> customers = CSVReader.readAll(tempFile.toString());
    assertEquals(1, customers.size());
    assertEquals("Tom", customers.get(0).get("first_name"));
    assertEquals("", customers.get(0).get("email"));
  }
}