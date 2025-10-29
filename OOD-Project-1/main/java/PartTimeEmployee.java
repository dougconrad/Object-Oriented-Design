import java.time.LocalDate;

/**
 * Class PartTimeEmployee extends class Employee, stores more information about given part-time
 * employee.
 */
public abstract class PartTimeEmployee extends Employee {

  protected Double contractualHours;
  protected Double actualWorkedHours;
  protected Double bonusOvertimeEarnings;

  private static final Double BASE_PRODUCTIVITY_MULTIPLIER = 3.7;
  private static final Double INTERMEDIATE_BONUS = 1.4;

  /**
   * Constructor for class PartTimeEmployee
   *
   * @param employeeID            - String, representing employee's ID
   * @param contactInfo           - ContactInfo, representing employee's contact info
   * @param employmentDate        - LocalDate, representing the day the employee started working
   * @param employmentLevel       - EmploymentLevel, representing employee's level
   * @param lastYearsEarnings     - Double, representing employee's earnings last year
   * @param contractualHours      - Double, representing employee's contractual hours
   * @param actualWorkedHours     - Double, representing employee's actual worked hours
   * @param bonusOvertimeEarnings - Double, representing employee's bonus and overtime earnings
   */
  public PartTimeEmployee(String employeeID, ContactInfo contactInfo,
      LocalDate employmentDate, EmploymentLevel employmentLevel, Double lastYearsEarnings,
      Double contractualHours, Double actualWorkedHours, Double bonusOvertimeEarnings) {
    super(employeeID, contactInfo, employmentDate, employmentLevel, lastYearsEarnings);
    this.contractualHours = contractualHours;
    this.actualWorkedHours = actualWorkedHours;
    this.bonusOvertimeEarnings = bonusOvertimeEarnings;
  }

  /**
   * Helper method for estimateProductivity()
   *
   * @return - double, base productivity score
   */
  protected double baseProductivity() {
    double productivity = (actualWorkedHours / contractualHours) * BASE_PRODUCTIVITY_MULTIPLIER;
    if (employmentLevel == EmploymentLevel.INTERMEDIATE_LEVEL) {
      productivity += INTERMEDIATE_BONUS;
    }
    return productivity;
  }

  /**
   * @return - Double, gives employee's contractual hours
   */
  public Double getContractualHours() {
    return contractualHours;
  }

  /**
   * @return - Double, gives employee's actual worked hours
   */
  public Double getActualWorkedHours() {
    return actualWorkedHours;
  }

  /**
   * @return - Double, gives employee's bonus and overtime earnings
   */
  public Double getBonusOvertimeEarnings() {
    return bonusOvertimeEarnings;
  }
}
