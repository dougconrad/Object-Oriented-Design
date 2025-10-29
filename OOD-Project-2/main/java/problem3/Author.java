package problem3;

public class Author implements Creator {

  public String firstName;
  public String lastName;

  /**
   * Constructor for class Author
   *
   * @param firstName - String, first name of author
   * @param lastName  - String, last name of author
   */
  public Author(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
