package assignment4;

import java.io.IOException;
import java.util.List;

/**
 * Entry point for the message generation program. This program reads customer data from a CSV file,
 * parses a specified template, and generates personalized emails or letters based on the
 * command-line arguments.
 */
public class Main {

  /**
   * Main method to run the program.
   *
   * @param args String[], command-line arguments for controlling template input, customer data, and
   *             output
   */
  public static void main(String[] args) {
    try {
      Arguments arguments = CommandLineParser.parse(args);
      List<Customer> customers = CSVReader.readAll(arguments.getCsvFile());

      if (customers.isEmpty()) {
        System.out.println("Warning: No customer data found in CSV file.");
      }

      if (arguments.isEmail()) {
        AGenerator emailGenerator = new EmailGenerator(
            arguments.getEmailTemplate(), arguments.getOutputDir());
        emailGenerator.generate(customers);
        System.out.printf("Generated %d %s file(s) in %s%n",
            customers.size(), emailGenerator.getType(), arguments.getOutputDir());
      }

      if (arguments.isLetter()) {
        AGenerator letterGenerator = new LetterGenerator(
            arguments.getLetterTemplate(), arguments.getOutputDir());
        letterGenerator.generate(customers);
        System.out.printf("Generated %d %s file(s) in %s%n",
            customers.size(), letterGenerator.getType(), arguments.getOutputDir());
      }

    } catch (IllegalArgumentException e) {
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
    } catch (IOException e) {
      System.err.println("Error reading/writing files: " + e.getMessage());
      System.exit(1);
    } catch (Exception e) {
      System.err.println("Unexpected error: " + e.getMessage());
      System.exit(1);
    }
  }
}
