package assignment4;

/**
 * Class Arguments stores information about the arguments
 */
public class Arguments {

  private boolean email;
  private String emailTemplate;
  private boolean letter;
  private String letterTemplate;
  private String outputDir;
  private String csvFile;

  /**
   * Constructor for the class Arguments. Constructs an empty Arguments object.
   */
  public Arguments() {
  }

  /**
   * Constructor for the class Arguments
   *
   * @param email          - boolean, whether to generate emails
   * @param emailTemplate  - String, the path to the email template
   * @param letter         - boolean, whether to generate letters
   * @param letterTemplate - String, the path to the letter template
   * @param outputDir      - String, the directory to store generated output
   * @param csvFile        - String, the path to the input CSV file
   */
  public Arguments(boolean email, String emailTemplate, boolean letter, String letterTemplate,
      String outputDir, String csvFile) {
    this.email = email;
    this.emailTemplate = emailTemplate;
    this.letter = letter;
    this.letterTemplate = letterTemplate;
    this.outputDir = outputDir;
    this.csvFile = csvFile;
  }

  /**
   * @return true if email generation is requested
   */
  public boolean isEmail() {
    return email;
  }

  /**
   * Sets whether email generation is requested.
   *
   * @param email - String, true to enable email generation
   */
  public void setEmail(boolean email) {
    this.email = email;
  }

  /**
   * @return - String, the email template file path
   */
  public String getEmailTemplate() {
    return emailTemplate;
  }

  /**
   * Sets the path to the email template.
   *
   * @param emailTemplate - String, path to the email template file
   */
  public void setEmailTemplate(String emailTemplate) {
    this.emailTemplate = emailTemplate;
  }

  /**
   * @return - boolean, true if letter generation is requested
   */
  public boolean isLetter() {
    return letter;
  }

  /**
   * Sets whether letter generation is requested.
   *
   * @param letter - boolean, true to enable letter generation
   */
  public void setLetter(boolean letter) {
    this.letter = letter;
  }

  /**
   * @return - String, the letter template file path
   */
  public String getLetterTemplate() {
    return letterTemplate;
  }

  /**
   * Sets the path to the letter template.
   *
   * @param letterTemplate - String, path to the letter template file
   */
  public void setLetterTemplate(String letterTemplate) {
    this.letterTemplate = letterTemplate;
  }

  /**
   * @return - String, the output directory where files should be written
   */
  public String getOutputDir() {
    return outputDir;
  }

  /**
   * Sets the output directory.
   *
   * @param outputDir - String, directory path for generated files
   */
  public void setOutputDir(String outputDir) {
    this.outputDir = outputDir;
  }

  /**
   * @return - String, the CSV file path containing customer data
   */
  public String getCsvFile() {
    return csvFile;
  }

  /**
   * Sets the input CSV file path.
   *
   * @param csvFile - String, path to the CSV file
   */
  public void setCsvFile(String csvFile) {
    this.csvFile = csvFile;
  }

  /**
   * Validates the command-line arguments provided by the user. Throws an IllegalArgumentException
   * if:
   * <ul>
   *   <li>CSV file or output directory is missing</li>
   *   <li>--email is provided without --email-template</li>
   *   <li>--letter is provided without --letter-template</li>
   *   <li>Neither --email nor --letter is specified</li>
   * </ul>
   *
   * @throws IllegalArgumentException if validation fails
   */
  public void validate() {
    if (csvFile == null || outputDir == null) {
      throw new IllegalArgumentException("Missing required options: --csv-file or --output-dir");
    }
    if (email && emailTemplate == null) {
      throw new IllegalArgumentException("Option --email requires --email-template.");
    }
    if (letter && letterTemplate == null) {
      throw new IllegalArgumentException("Option --letter requires --letter-template.");
    }
    if (!email && !letter) {
      throw new IllegalArgumentException("At least one of --email or --letter must be provided.");
    }
  }
}
