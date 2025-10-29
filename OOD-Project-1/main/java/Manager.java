import java.time.LocalDate;
import java.util.Objects;

/**
 * Class Manager extends class FullTimeEmployee, stores more information about given manager.
 */
public class Manager extends FullTimeEmployee {

  private Integer numEmployees;

  private static final Double MANAGER_BONUS = 1.8;
  private static final Integer MANAGER_BONUS_THRESHOLD = 8;

  /**
   * Constructor for class Manager
   *
   * @param employeeID        - String, representing employee's ID
   * @param contactInfo       - ContactInfo, representing employee's contact info
   * @param employmentDate    - LocalDate, representing the day the employee started working
   * @param employmentLevel   - EmploymentLevel, representing employee's level
   * @param lastYearsEarnings - Double, representing employee's earnings last year
   * @param basePay           - Double, representing employee's base pay
   * @param bonuses           - Double, representing employee's earnings from bonuses
   * @param overtime          - Double, representing employee's earnings from overtime
   * @param lastPromotionDate - LocalDate, representing employee's last promotion date
   * @param numProjects       - Integer, representing employee's number of projects
   * @param numEmployees      - Integer, representing manager's number of employees
   */
  public Manager(String employeeID, ContactInfo contactInfo, LocalDate employmentDate,
      EmploymentLevel employmentLevel, Double lastYearsEarnings, Double basePay, Double bonuses,
      Double overtime, LocalDate lastPromotionDate, Integer numProjects,
      Integer numEmployees) {
    super(employeeID, contactInfo, employmentDate, employmentLevel, lastYearsEarnings, basePay,
        bonuses, overtime, lastPromotionDate, numProjects);
    this.numEmployees = numEmployees;
  }

  public Double estimateProductivity() {
    double productivity = super.baseProductivity();
    if (numEmployees > MANAGER_BONUS_THRESHOLD) {
      productivity += MANAGER_BONUS;
    }
    return productivity;
  }

  /**
   * @return - Integer, gives manager's number of employees
   */
  public Integer getNumEmployees() {
    return numEmployees;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Manager manager = (Manager) o;
    return Objects.equals(numEmployees, manager.numEmployees);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(numEmployees);
  }

  @Override
  public String toString() {
    return "Manager{" +
        "numEmployees=" + numEmployees +
        ", basePay=" + basePay +
        ", bonuses=" + bonuses +
        ", overtime=" + overtime +
        ", lastPromotionDate=" + lastPromotionDate +
        ", numProjects=" + numProjects +
        ", employeeID='" + employeeID + '\'' +
        ", contactInfo=" + contactInfo +
        ", employmentDate=" + employmentDate +
        ", employmentLevel=" + employmentLevel +
        ", lastYearsEarnings=" + lastYearsEarnings +
        '}';
  }
}
