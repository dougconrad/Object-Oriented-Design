package assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArgumentsTest {

  @Test
  public void testValidEmailArguments() {
    Arguments args = new Arguments(true, "email.txt", false, null, "out", "data.csv");
    assertDoesNotThrow(args::validate);
    assertTrue(args.isEmail());
    assertEquals("email.txt", args.getEmailTemplate());
    assertEquals("out", args.getOutputDir());
    assertEquals("data.csv", args.getCsvFile());
  }

  @Test
  public void testValidLetterArguments() {
    Arguments args = new Arguments(false, null, true, "letter.txt", "out", "data.csv");
    assertDoesNotThrow(args::validate);
    assertTrue(args.isLetter());
    assertEquals("letter.txt", args.getLetterTemplate());
  }

  @Test
  public void testMissingCsvFile() {
    Arguments args = new Arguments(true, "email.txt", false, null, "out", null);
    Exception e = assertThrows(IllegalArgumentException.class, args::validate);
    assertEquals("Missing required options: --csv-file or --output-dir", e.getMessage());
  }

  @Test
  public void testMissingOutputDir() {
    Arguments args = new Arguments(true, "email.txt", false, null, null, "data.csv");
    Exception e = assertThrows(IllegalArgumentException.class, args::validate);
    assertEquals("Missing required options: --csv-file or --output-dir", e.getMessage());
  }

  @Test
  public void testEmailWithoutTemplate() {
    Arguments args = new Arguments(true, null, false, null, "out", "data.csv");
    Exception e = assertThrows(IllegalArgumentException.class, args::validate);
    assertEquals("Option --email requires --email-template.", e.getMessage());
  }

  @Test
  public void testLetterWithoutTemplate() {
    Arguments args = new Arguments(false, null, true, null, "out", "data.csv");
    Exception e = assertThrows(IllegalArgumentException.class, args::validate);
    assertEquals("Option --letter requires --letter-template.", e.getMessage());
  }

  @Test
  public void testNoEmailOrLetter() {
    Arguments args = new Arguments(false, null, false, null, "out", "data.csv");
    Exception e = assertThrows(IllegalArgumentException.class, args::validate);
    assertEquals("At least one of --email or --letter must be provided.", e.getMessage());
  }
}
