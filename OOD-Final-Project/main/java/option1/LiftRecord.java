package option1;

/**
 * Class to keep track of a single lift record
 */
public class LiftRecord {

  String resortID;
  String dayNumber;
  String timestamp;
  String skierID;
  String liftID;

  /**
   * Constructor for a single lift record
   *
   * @param line - String, the single lift record in a dataset
   */
  public LiftRecord(String line) {
    String[] fields = line.split(",");
    this.resortID = fields[0];
    this.dayNumber = fields[1];
    this.timestamp = fields[4];
    this.skierID = fields[2];
    this.liftID = fields[3];
  }


}
