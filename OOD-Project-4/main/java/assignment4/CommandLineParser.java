package assignment4;

/**
 * Class CommandLineParser stores information about the command line parser. Responsible for parsing
 * command-line arguments and returning a populated {Arguments} object. This parser supports the
 * following options:
 * <ul>
 *   <li>--email</li>
 *   <li>--letter</li>
 *   <li>--email-template &lt;file&gt;</li>
 *   <li>--letter-template &lt;file&gt;</li>
 *   <li>--output-dir &lt;folder&gt;</li>
 *   <li>--csv-file &lt;file&gt;</li>
 * </ul>
 * Options can be provided in any order.
 */
public class CommandLineParser {

  /**
   * Private constructor to prevent instantiation.
   */
  private CommandLineParser() {
  }

  /**
   * Parses the provided command-line arguments into an {@link Arguments} object.
   *
   * @param args - String[], the array of command-line arguments
   * @return a fully populated and validated Arguments object
   * @throws IllegalArgumentException if any option is invalid or required values are missing
   */
  public static Arguments parse(String[] args) {
    Arguments arguments = new Arguments();
    for (int i = 0; i < args.length; i++) {
      String option = args[i];
      switch (option) {
        case "--email":
          arguments.setEmail(true);
          break;
        case "--letter":
          arguments.setLetter(true);
          break;
        case "--email-template":
          arguments.setEmailTemplate(args[++i]);
          break;
        case "--letter-template":
          arguments.setLetterTemplate(args[++i]);
          break;
        case "--output-dir":
          arguments.setOutputDir(args[++i]);
          break;
        case "--csv-file":
          arguments.setCsvFile(args[++i]);
          break;
        default:
          throw new IllegalArgumentException("Unknown argument: " + args[i]);
      }
    }
    arguments.validate();
    return arguments;
  }
}
