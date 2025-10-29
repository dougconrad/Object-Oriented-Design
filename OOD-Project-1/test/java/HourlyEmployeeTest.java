import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HourlyEmployeeTest {

  private HourlyEmployee testEmployee1;
  private HourlyEmployee testEmployee2;
  private HourlyEmployee testEmployee3;
  private HourlyEmployee testEmployee4;
  private ContactInfo contactInfo;

  @BeforeEach
  void setUp() {
    Name name = new Name("Douglas", "Conrad");
    Name emergencyContact = new Name("Mrs", "Doug");
    contactInfo = new ContactInfo(name, "1000 Lenora St", "8603094412",
        "conrad.do@northeastern.edu", emergencyContact);
    testEmployee1 = new HourlyEmployee("1", contactInfo, LocalDate.of(2024, 1, 1),
        EmploymentLevel.MID_LEVEL, 40000.0, 20.0, 24.0, 4000.0, 10.0);
    testEmployee2 = new HourlyEmployee("1", contactInfo, LocalDate.of(2024, 1, 1),
        EmploymentLevel.INTERMEDIATE_LEVEL, 40000.0, 20.0, 24.0, 4000.0, 10.0);
    testEmployee3 = new HourlyEmployee("1", contactInfo, LocalDate.of(2024, 1, 1),
        EmploymentLevel.MID_LEVEL, 40000.0, 20.0, 24.0, 4000.0, 20.0);
    testEmployee4 = new HourlyEmployee("1", contactInfo, LocalDate.of(2024, 1, 1),
        EmploymentLevel.MID_LEVEL, 40000.0, 20.0, 24.0, 4000.0, 10.0);
  }

  @Test
  void getContractualHours() {
    assertEquals(20.0, testEmployee1.getContractualHours());
  }

  @Test
  void getActualWorkedHours() {
    assertEquals(24.0, testEmployee1.getActualWorkedHours());
  }

  @Test
  void getBonusOvertimeEarnings() {
    assertEquals(4000.0, testEmployee1.getBonusOvertimeEarnings());
  }

  @Test
  void getEmployeeID() {
    assertEquals("1", testEmployee1.getEmployeeID());
  }

  @Test
  void getContactInfo() {
    assertEquals(contactInfo, testEmployee1.getContactInfo());
  }

  @Test
  void getEmploymentDate() {
    assertEquals(LocalDate.of(2024, 1, 1), testEmployee1.getEmploymentDate());
  }

  @Test
  void getEmploymentLevel() {
    assertEquals(EmploymentLevel.MID_LEVEL, testEmployee1.getEmploymentLevel());
  }

  @Test
  void getLastYearsEarnings() {
    assertEquals(40000.0, testEmployee1.getLastYearsEarnings());
  }

  @Test
  void estimateProductivity() {
    assertEquals(7.44, testEmployee1.estimateProductivity(), 0.001);
    assertEquals(8.84, testEmployee2.estimateProductivity(), 0.001);
    assertEquals(4.44, testEmployee3.estimateProductivity(), 0.001);
  }

  @Test
  void getHourlyRate() {
    assertEquals(10.0, testEmployee1.getHourlyRate());
  }

  @Test
  void testEquals() {
    assertEquals(testEmployee1, testEmployee4);

  }

  @Test
  void testHashCode() {
    assertEquals(testEmployee1.hashCode(), testEmployee4.hashCode());
  }
}