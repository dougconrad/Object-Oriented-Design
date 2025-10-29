package assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandLineParserTest {

    @Test
    void testValidEmailOnlyArguments() {
        String[] args = {
                "--email", "--email-template", "email.txt",
                "--output-dir", "out", "--csv-file", "data.csv"
        };

        Arguments result = CommandLineParser.parse(args);
        assertTrue(result.isEmail());
        assertEquals("email.txt", result.getEmailTemplate());
        assertEquals("out", result.getOutputDir());
        assertEquals("data.csv", result.getCsvFile());
        assertFalse(result.isLetter());
    }

    @Test
    void testValidLetterOnlyArguments() {
        String[] args = {
                "--letter", "--letter-template", "letter.txt",
                "--output-dir", "out", "--csv-file", "data.csv"
        };

        Arguments result = CommandLineParser.parse(args);
        assertTrue(result.isLetter());
        assertEquals("letter.txt", result.getLetterTemplate());
        assertEquals("out", result.getOutputDir());
        assertEquals("data.csv", result.getCsvFile());
        assertFalse(result.isEmail());
    }

    @Test
    void testBothEmailAndLetterArguments() {
        String[] args = {
                "--email", "--email-template", "email.txt",
                "--letter", "--letter-template", "letter.txt",
                "--output-dir", "out", "--csv-file", "data.csv"
        };

        Arguments result = CommandLineParser.parse(args);
        assertTrue(result.isEmail());
        assertTrue(result.isLetter());
        assertEquals("email.txt", result.getEmailTemplate());
        assertEquals("letter.txt", result.getLetterTemplate());
    }

    @Test
    void testMissingTemplateForEmailThrows() {
        String[] args = {
                "--email", "--output-dir", "out", "--csv-file", "data.csv"
        };
        Exception ex = assertThrows(IllegalArgumentException.class, () -> CommandLineParser.parse(args));
        assertTrue(ex.getMessage().contains("requires --email-template"));
    }

    @Test
    void testUnknownArgumentThrows() {
        String[] args = {
                "--email", "--banana", "yellow", "--output-dir", "out", "--csv-file", "data.csv"
        };
        Exception ex = assertThrows(IllegalArgumentException.class, () -> CommandLineParser.parse(args));
        assertTrue(ex.getMessage().contains("Unknown argument"));
    }
}
