import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IndividualContributorTest {

  private IndividualContributor testEmployee1;
  private IndividualContributor testEmployee2;
  private IndividualContributor testEmployee3;
  private IndividualContributor testEmployee4;
  private IndividualContributor testEmployee5;
  private ContactInfo contactInfo;

  @BeforeEach
  void setUp() {
    Name name = new Name("Douglas", "Conrad");
    Name emergencyContact = new Name("Mrs", "Doug");
    contactInfo = new ContactInfo(name, "1000 Lenora St", "8603094412",
        "conrad.do@northeastern.edu", emergencyContact);
    testEmployee1 = new IndividualContributor("1", contactInfo, LocalDate.of(2020, 1, 1),
        EmploymentLevel.MID_LEVEL, 100000.0, 80000.0, 10000.0,
        10000.0, LocalDate.of(2024, 1, 1), 2,
        8, 1, 1);
    testEmployee2 = new IndividualContributor("1", contactInfo, LocalDate.of(2020, 1, 1),
        EmploymentLevel.MID_LEVEL, 100000.0, 80000.0, 10000.0,
        10000.0, LocalDate.of(2024, 1, 1), 2,
        8, 10, 1);
    testEmployee3 = new IndividualContributor("1", contactInfo, LocalDate.of(2020, 1, 1),
        EmploymentLevel.INTERMEDIATE_LEVEL, 100000.0, 80000.0, 10000.0,
        10000.0, LocalDate.of(2024, 1, 1), 2,
        8, 1, 1);
    testEmployee4 = new IndividualContributor("1", contactInfo, LocalDate.of(2020, 1, 1),
        EmploymentLevel.MID_LEVEL, 100000.0, 80000.0, 10000.0,
        10000.0, LocalDate.of(2024, 1, 1), 20,
        8, 1, 1);
    testEmployee5 = new IndividualContributor("1", contactInfo, LocalDate.of(2020, 1, 1),
        EmploymentLevel.MID_LEVEL, 100000.0, 80000.0, 10000.0,
        10000.0, LocalDate.of(2020, 1, 1), 2,
        8, 1, 1);
  }

  @Test
  void getBasePay() {
    assertEquals(80000.0, testEmployee1.getBasePay());
  }

  @Test
  void getBonuses() {
    assertEquals(10000.0, testEmployee1.getBonuses());
  }

  @Test
  void getOvertime() {
    assertEquals(10000.0, testEmployee1.getOvertime());
  }

  @Test
  void getLastPromotionDate() {
    assertEquals(LocalDate.of(2024, 1, 1), testEmployee1.getLastPromotionDate());
  }

  @Test
  void getNumProjects() {
    assertEquals(2, testEmployee1.getNumProjects());
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
    assertEquals(LocalDate.of(2020, 1, 1), testEmployee1.getEmploymentDate());
  }

  @Test
  void getEmploymentLevel() {
    assertEquals(EmploymentLevel.MID_LEVEL, testEmployee1.getEmploymentLevel());
  }

  @Test
  void getLastYearsEarnings() {
    assertEquals(100000.0, testEmployee1.getLastYearsEarnings());
  }

  @Test
  void estimateProductivity() {
    assertEquals(1.25, testEmployee1.estimateProductivity());
    assertEquals(2.55, testEmployee2.estimateProductivity());
    assertEquals(2.65, testEmployee3.estimateProductivity());
    assertEquals(2.75, testEmployee4.estimateProductivity());
    assertEquals(0.45, testEmployee5.estimateProductivity(), 0.001);
  }

  @Test
  void getNumPatents() {
    assertEquals(8, testEmployee1.getNumPatents());
  }

  @Test
  void getNumPublications() {
    assertEquals(1, testEmployee1.getNumPublications());
  }

  @Test
  void getNumExternalCollabs() {
    assertEquals(1, testEmployee1.getNumExternalCollabs());
  }
}