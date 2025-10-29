package assignment4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Abstract file generator class
 */
public abstract class AGenerator {

  protected final String templatePath;
  protected final String outputDirectory;

  /**
   * Constructs for the class AGenerator
   *
   * @param templatePath    - String, the path to the message template file
   * @param outputDirectory - String, the path to the output directory
   */
  public AGenerator(String templatePath, String outputDirectory) {
    this.templatePath = templatePath;
    this.outputDirectory = outputDirectory;
  }

  /**
   * Generates a filename for the output file for the given index.
   *
   * @param index - int, representing the customer index
   * @return - String, the filename for the output file
   */
  protected abstract String generateFilename(int index);

  /**
   * Returns the type of generator (e.g., "email" or "letter").
   *
   * @return - String, the generator type
   */
  public abstract String getType();

  /**
   * Generates personalized messages for each customer using the provided template. The output is
   * written to individual files in the specified output directory.
   *
   * @param customers - List<Customer>, the list of customers to generate messages for
   * @throws IOException if reading the template or writing files fails
   */
  public final void generate(List<Customer> customers) throws IOException {
    String template = TemplateProcessor.readTemplate(templatePath);
    Path outputPath = Paths.get(outputDirectory);
    Files.createDirectories(outputPath);

    for (int i = 0; i < customers.size(); i++) {
      Customer customer = customers.get(i);
      String processedContent = TemplateProcessor.processTemplate(template, customer);
      String filename = generateFilename(i + 1);
      Path filePath = outputPath.resolve(filename);
      Files.writeString(filePath, processedContent);
    }
  }
}
