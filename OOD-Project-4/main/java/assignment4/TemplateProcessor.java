package assignment4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class TemplateProcessor stores information about the template processor A utility class for
 * loading and processing message templates with dynamic fields. Replaces placeholders in the format
 * [[field_name]] with customer-specific data.
 */
public class TemplateProcessor {

  private static final Pattern pattern = Pattern.compile("\\[\\[([^]]+)]]");

  /**
   * Private constructor to prevent instantiation.
   */
  private TemplateProcessor() {
  }

  /**
   * Reads the contents of the template file from disk.
   *
   * @param templatePath - String, the path to the template file
   * @return the file contents as a single String
   * @throws IOException if reading the file fails
   */
  public static String readTemplate(String templatePath) throws IOException {
    Path path = Paths.get(templatePath);
    return Files.readString(path);
  }

  /**
   * Processes the template by replacing all [[field]] placeholders with values from the customer.
   *
   * @param template - String, the template string containing placeholders
   * @param customer - String, the customer whose data will replace the placeholders
   * @return the final string with all substitutions made
   * @throws IOException if processing fails (should not normally throw)
   */
  public static String processTemplate(String template, Customer customer) throws IOException {
    StringBuilder result = new StringBuilder();
    Matcher matcher = pattern.matcher(template);
    while (matcher.find()) {
      String fieldName = matcher.group(1);
      String replacement = customer.get(fieldName);
      matcher.appendReplacement(result, Matcher.quoteReplacement(replacement));
    }
    matcher.appendTail(result);
    return result.toString();
  }
}
