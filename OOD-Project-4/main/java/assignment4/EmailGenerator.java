package assignment4;

/**
 * Class EmailGenerator stores information about the email generator Concrete generator for creating
 * personalized email messages from a template. Extends {AGenerator} and provides email-specific
 * filename generation.
 */
public class EmailGenerator extends AGenerator {

  /**
   * Constructor for the class EmailGenerator
   *
   * @param templatePath - String, path to the email template file
   * @param outputDir    - String, path to the directory where email files will be saved
   */
  public EmailGenerator(String templatePath, String outputDir) {
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
    return "email_" + index + ".txt";
  }

  /**
   * Returns the type of generator.
   *
   * @return the string "email"
   */
  @Override
  public String getType() {
    return "email";
  }
}
