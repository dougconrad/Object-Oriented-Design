package assignment4;

import java.util.Map;

/**
 * Class Customer stores information about a customer. Represents a customer record parsed from a
 * CSV file. Stores data as key-value pairs, where keys are column headers.
 */
public class Customer {

  private final Map<String, String> data;

  /**
   * Constructor for the class Customer
   *
   * @param data - Map<String, String>, a map of field names to field values
   */
  public Customer(Map<String, String> data) {
    this.data = data;
  }

  /**
   * Retrieves the value associated with a specific field name.
   *
   * @param fieldName - String, the name of the field (e.g., \"email\", \"first_name\")
   * @return - String, the field's value, or an empty String if the field is not present
   */
  public String get(String fieldName) {
    return data.getOrDefault(fieldName, "");
  }

  /**
   * Returns all field data for this customer.
   *
   * @return - Map<String, String>, a map of all fields and values
   */
  public Map<String, String> getAllData() {
    return data;
  }


  /**
   * Gets the field.
   *
   * @param fieldName - String, the field name
   * @return String, the field name
   */
  public String getField(String fieldName) {
    return get(fieldName);
  }
}
