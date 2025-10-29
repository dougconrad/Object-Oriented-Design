package option1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SkiersCSVGeneratorTest {

  private static final String TEST_FILE = "test_skiers.csv";

  @AfterEach
  void tearDown() throws IOException {
    Files.deleteIfExists(Paths.get(TEST_FILE));
  }

  @Test
  void testGenerate() throws IOException {
    Map<Integer, Integer> skierVerticals = new HashMap<>();
    skierVerticals.put(1, 1000);
    skierVerticals.put(2, 2000);
    new SkiersCSVGenerator(TEST_FILE, skierVerticals).generate();
    List<String> lines = Files.readAllLines(Paths.get(TEST_FILE));
    assertEquals("SkierID,Vertical Distance", lines.get(0));
    assertTrue(lines.stream().anyMatch(line -> line.startsWith("1,1000")));
    assertTrue(lines.stream().anyMatch(line -> line.startsWith("2,2000")));
  }
}