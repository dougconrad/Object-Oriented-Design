package assignment4;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class EmailGeneratorTest {

    private Path tempDir;
    private Path templateFile;

    @BeforeEach
    public void setUp() throws IOException {
        tempDir = Files.createTempDirectory("emails");
        templateFile = Files.createTempFile("email-template", ".txt");
        Files.writeString(templateFile, "To:[[email]]\nHello [[first_name]] [[last_name]]!");
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.walk(tempDir)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);

        Files.deleteIfExists(templateFile);
    }

    @Test
    public void testEmailGeneration() throws IOException {
        Customer customer = new Customer(Map.of(
                "first_name", "Sam",
                "last_name", "Lee",
                "email", "sam@example.com"
        ));
        List<Customer> customers = List.of(customer);

        EmailGenerator generator = new EmailGenerator(templateFile.toString(), tempDir.toString());
        generator.generate(customers);

        Path generated = tempDir.resolve("email_1.txt");
        assertTrue(Files.exists(generated), "Email file should be created");

        String content = Files.readString(generated);
        assertTrue(content.contains("To:sam@example.com"));
        assertTrue(content.contains("Hello Sam Lee!"));
    }

    @Test
    public void testFilenameGeneration() {
        EmailGenerator generator = new EmailGenerator("template.txt", "out");
        assertEquals("email_3.txt", generator.generateFilename(3));
    }

    @Test
    public void testGetType() {
        EmailGenerator generator = new EmailGenerator("template.txt", "out");
        assertEquals("email", generator.getType());
    }
}
