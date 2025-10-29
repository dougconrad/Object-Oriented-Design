package option1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class LiftsCSVGeneratorTest {

  private static final String TEST_FILE = "test_lifts.csv";

  @AfterEach
  void tearDown() throws IOException {
    Files.deleteIfExists(Paths.get(TEST_FILE));
  }

  @Test
  void testGenerate() throws IOException {
    Map<Integer, Integer> liftData = new HashMap<>();
    liftData.put(1, 100);
    liftData.put(20, 50);
    liftData.put(40, 200);
    new LiftsCSVGenerator(TEST_FILE, liftData).generate();
    List<String> lines = Files.readAllLines(Paths.get(TEST_FILE));
    assertEquals("LiftID, Number of Rides", lines.get(0));
    assertTrue(lines.stream().anyMatch(line -> line.equals("1,100")));
    assertTrue(lines.stream().anyMatch(line -> line.equals("20,50")));
    assertTrue(lines.stream().anyMatch(line -> line.equals("40,200")));
    assertEquals(41, lines.size());
  }
}