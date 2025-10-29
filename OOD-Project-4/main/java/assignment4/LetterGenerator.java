package assignment4;

/**
 * Class LetterGenerator stores information about the letter generator Concrete generator for
 * creating personalized letter messages from a template. Extends {AGenerator} and provides
 * letter-specific filename generation.
 */
public class LetterGenerator extends AGenerator {

  /**
   * Constructor for the class LetterGenerator.
   *
   * @param templatePath - String, path to the letter template file
   * @param outputDir    - String, path to the directory where letter files will be saved
   */
  public LetterGenerator(String templatePath, String outputDir) {
    super(templatePath, outputDir);
  }

  /**
   * Generates a unique filename for an email message.
   *
   * @param index - int, the 1-based index of the customer
   * @return a filename in the format "email_X.txt"
   */
  @Override
  protected String generateFilename(int index) {
    return "letter_" + index + ".txt";
  }

  /**
   * Returns the type of generator.
   *
   * @return the String "letter"
   */
  @Override
  public String getType() {
    return "letter";
  }
}
