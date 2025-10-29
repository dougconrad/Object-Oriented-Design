package problem3;

public class Book extends Item {

  /**
   * Constructor for class Book
   *
   * @param creator     - Creator, creator of the item
   * @param title       - String, title of the item
   * @param releaseYear - Integer, year item was released
   */
  public Book(Author creator, String title, Integer releaseYear) {
    super(creator, title, releaseYear);
  }
}
