package assignment4;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the AGenerator class using a concrete test subclass.
 */
public class AGeneratorTest {

  private Path tempDir;
  private Path templateFile;

  @BeforeEach
  public void setup() throws IOException {
    tempDir = Files.createTempDirectory("test-output");
    templateFile = Files.createTempFile("template", ".txt");
    Files.writeString(templateFile, "Hello [[first_name]] [[last_name]]!");
  }

  @AfterEach
  public void cleanup() throws IOException {
    Files.walk(tempDir)
        .sorted(Comparator.reverseOrder())
        .map(Path::toFile)
        .forEach(File::delete);
    Files.deleteIfExists(templateFile);
  }

  @Test
  public void testGenerateWritesFilesCorrectly() throws IOException {
    List<Customer> customers = List.of(
        new Customer(Map.of("first_name", "Savino", "last_name", "Ventura")),
        new Customer(Map.of("first_name", "John", "last_name", "Dunay"))
    );

    AGenerator generator = new TestGenerator(templateFile.toString(), tempDir.toString());
    generator.generate(customers);

    Path file1 = tempDir.resolve("test_output_1.txt");
    Path file2 = tempDir.resolve("test_output_2.txt");

    assertTrue(Files.exists(file1));
    assertTrue(Files.exists(file2));

    String content1 = Files.readString(file1);
    String content2 = Files.readString(file2);

    assertEquals("Hello Savino Ventura!", content1.trim());
    assertEquals("Hello John Dunay!", content2.trim());
  }

  private static class TestGenerator extends AGenerator {

    public TestGenerator(String templatePath, String outputDirectory) {
      super(templatePath, outputDirectory);
    }

    @Override
    protected String generateFilename(int index) {
      return "test_output_" + index + ".txt";
    }

    @Override
    public String getType() {
      return "test";
    }
  }
}
