package problem3;

public abstract class Item {

  public Creator creator;
  public String title;
  public Integer releaseYear;

  /**
   * Constructor for class Item
   *
   * @param creator     - Creator, creator of the item
   * @param title       - String, title of the item
   * @param releaseYear - Integer, year item was released
   */
  public Item(Creator creator, String title, Integer releaseYear) {
    this.creator = creator;
    this.title = title;
    this.releaseYear = releaseYear;
  }

}
