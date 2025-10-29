package problem3;

public class RecordingArtist implements Creator {

  public String firstName;
  public String lastName;

  /**
   * Constructor for class RecordingArtist
   *
   * @param firstName - String, first name of artist
   * @param lastName  - String, last name of artist
   */
  public RecordingArtist(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
