package option1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LiftRecordTest {

  @Test
  void testLiftRecord() {
    String line = "0,1,2,3,4";
    LiftRecord record = new LiftRecord(line);
    assertEquals("0", record.resortID);
    assertEquals("1", record.dayNumber);
    assertEquals("4", record.timestamp);
    assertEquals("2", record.skierID);
    assertEquals("3", record.liftID);
  }
}