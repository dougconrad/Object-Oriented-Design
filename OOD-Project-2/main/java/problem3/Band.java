package problem3;

import java.util.ArrayList;

public class Band implements Creator {

  public String name;
  public ArrayList<RecordingArtist> members;

  /**
   * Constructor for class Band
   *
   * @param name    - String, name of band
   * @param members - ArrayList, members in band
   */
  public Band(String name, ArrayList<RecordingArtist> members) {
    this.name = name;
    this.members = members;
  }
}
