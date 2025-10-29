package option1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class HoursCSVGeneratorTest {

  private static final String TEST_FILE = "test_hours.csv";

  @AfterEach
  void tearDown() throws IOException {
    Files.deleteIfExists(Paths.get(TEST_FILE));
  }

  @Test
  void testGenerateReportCreatesCorrectFile() throws IOException {
    Map<Integer, Map<Integer, Integer>> hourLiftData = new HashMap<>();

    Map<Integer, Integer> nineAmRides = new HashMap<>();
    nineAmRides.put(5, 30);
    nineAmRides.put(12, 50);
    hourLiftData.put(9, nineAmRides);
    Map<Integer, Integer> tenAmRides = new HashMap<>();
    tenAmRides.put(7, 70);
    hourLiftData.put(10, tenAmRides);
    new HoursCSVGenerator(TEST_FILE, hourLiftData).generate();
    List<String> lines = Files.readAllLines(Paths.get(TEST_FILE));
    assertTrue(lines.get(0).startsWith("Hour 9,Hour 10"));
    assertTrue(lines.stream().anyMatch(line -> line.contains("12 50")));
    assertTrue(lines.stream().anyMatch(line -> line.contains("5 30")));
    assertTrue(lines.stream().anyMatch(line -> line.contains("7 70")));
    assertEquals(11, lines.size());
  }
}