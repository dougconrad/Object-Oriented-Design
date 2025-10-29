package option1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SkiDataReaderTest {

  @Test
  void testSkiDataReader() throws IOException {
    String tempFile = "test_data.csv";
    Files.write(Paths.get(tempFile),
        Arrays.asList("ResortID,DayNumber,Timestamp,SkierID,LiftID", "0,1,2,3,4"));
    SkiDataReader reader = new SkiDataReader();
    List<LiftRecord> records = reader.read(tempFile);
    assertEquals(1, records.size());
    assertEquals("3", records.get(0).liftID);
    Files.deleteIfExists(Paths.get(tempFile));
  }
}