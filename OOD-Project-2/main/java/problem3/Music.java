package problem3;

public class Music extends Item {

  /**
   * Constructor for class Music
   *
   * @param creator     - Creator, creator of the music
   * @param title       - String, title of the music
   * @param releaseYear - Integer, year music was released
   */
  public Music(Creator creator, String title, Integer releaseYear) {
    super(creator, title, releaseYear);
  }
}
