import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagerTest {

  private Manager testManager1;
  private Manager testManager2;
  private Manager testManager3;
  private Manager testManager4;
  private Manager testManager5;
  private ContactInfo contactInfo;

  @BeforeEach
  void setUp() {
    Name name = new Name("Douglas", "Conrad");
    Name emergencyContact = new Name("Mrs", "Doug");
    contactInfo = new ContactInfo(name, "1000 Lenora St", "8603094412",
        "conrad.do@northeastern.edu", emergencyContact);
    testManager1 = new Manager("1", contactInfo, LocalDate.of(2020, 1, 1),
        EmploymentLevel.MID_LEVEL, 100000.0, 80000.0, 10000.0,
        10000.0, LocalDate.of(2024, 1, 1), 2, 8);
    testManager2 = new Manager("1", contactInfo, LocalDate.of(2020, 1, 1),
        EmploymentLevel.MID_LEVEL, 100000.0, 80000.0, 10000.0,
        10000.0, LocalDate.of(2024, 1, 1), 3, 8);
    testManager3 = new Manager("1", contactInfo, LocalDate.of(2020, 1, 1),
        EmploymentLevel.MID_LEVEL, 100000.0, 80000.0, 10000.0,
        10000.0, LocalDate.of(2024, 1, 1), 2, 9);
    testManager4 = new Manager("1", contactInfo, LocalDate.of(2020, 1, 1),
        EmploymentLevel.MID_LEVEL, 100000.0, 80000.0, 10000.0,
        10000.0, LocalDate.of(2020, 1, 1), 2, 8);
    testManager5 = new Manager("1", contactInfo, LocalDate.of(2020, 1, 1),
        EmploymentLevel.INTERMEDIATE_LEVEL, 100000.0, 80000.0, 10000.0,
        10000.0, LocalDate.of(2024, 1, 1), 2, 8);
  }

  @Test
  void testGetBasePay() {
    assertEquals(80000.0, testManager1.getBasePay());
  }

  @Test
  void testGetBonuses() {
    assertEquals(10000.0, testManager1.getBonuses());
  }

  @Test
  void testGetOvertime() {
    assertEquals(10000.0, testManager1.getOvertime());
  }

  @Test
  void testGetLastPromotionDate() {
    assertEquals(LocalDate.of(2024, 1, 1), testManager1.getLastPromotionDate());
  }

  @Test
  void testGetNumProjects() {
    assertEquals(2, testManager1.getNumProjects());
  }

  @Test
  void testGetEmployeeID() {
    assertEquals("1", testManager1.getEmployeeID());
  }

  @Test
  void testGetContactInfo() {
    assertEquals(contactInfo, testManager1.getContactInfo());
  }

  @Test
  void testGetEmploymentDate() {
    assertEquals(LocalDate.of(2020, 1, 1), testManager1.getEmploymentDate());
  }

  @Test
  void testGetEmploymentLevel() {
    assertEquals(EmploymentLevel.MID_LEVEL, testManager1.getEmploymentLevel());
  }

  @Test
  void testGetLastYearsEarnings() {
    assertEquals(100000.0, testManager1.getLastYearsEarnings());
  }

  @Test
  void testEstimateProductivity() {
    assertEquals(1.25, testManager1.estimateProductivity(), 0.001);
    assertEquals(2.75, testManager2.estimateProductivity(), 0.001);
    assertEquals(3.05, testManager3.estimateProductivity(), 0.001);
    assertEquals(0.45, testManager4.estimateProductivity(), 0.001);
    assertEquals(2.65, testManager5.estimateProductivity(), 0.001);
  }

  @Test
  void testGetNumEmployees() {
    assertEquals(8, testManager1.getNumEmployees());
  }
}