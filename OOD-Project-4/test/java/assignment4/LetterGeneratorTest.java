package assignment4;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class LetterGeneratorTest {

    private Path tempDir;
    private Path templateFile;

    @BeforeEach
    public void setUp() throws IOException {
        tempDir = Files.createTempDirectory("letters");
        templateFile = Files.createTempFile("letter-template", ".txt");
        Files.writeString(templateFile,
                "[[first_name]] [[last_name]]\n[[address]], [[city]]\n([[email]])\n\nDear [[first_name]],");
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
    public void testLetterGeneration() throws IOException {
        Customer customer = new Customer(Map.of(
                "first_name", "Lara",
                "last_name", "Croft",
                "address", "123 Tomb Rd",
                "city", "London",
                "email", "lara@adventure.org"
        ));
        List<Customer> customers = List.of(customer);

        LetterGenerator generator = new LetterGenerator(templateFile.toString(), tempDir.toString());
        generator.generate(customers);

        Path generated = tempDir.resolve("letter_1.txt");
        assertTrue(Files.exists(generated), "Letter file should be created");

        String content = Files.readString(generated);
        assertTrue(content.contains("Lara Croft"));
        assertTrue(content.contains("123 Tomb Rd, London"));
        assertTrue(content.contains("(lara@adventure.org)"));
        assertTrue(content.contains("Dear Lara,"));
    }

    @Test
    public void testFilenameGeneration() {
        LetterGenerator generator = new LetterGenerator("template.txt", "out");
        assertEquals("letter_2.txt", generator.generateFilename(2));
    }

    @Test
    public void testGetType() {
        LetterGenerator generator = new LetterGenerator("template.txt", "out");
        assertEquals("letter", generator.getType());
    }
}
