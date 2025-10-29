import java.time.LocalDate;

/**
 * Class FullTimeEmployee extends class Employee, stores more information about given full time
 * employee.
 */
public abstract class FullTimeEmployee extends Employee {

  protected Double basePay;
  protected Double bonuses;
  protected Double overtime;
  protected LocalDate lastPromotionDate;
  protected Integer numProjects;

  private static final Double NUM_PROJECTS_BONUS = 1.5;
  private static final Integer NUM_PROJECTS_BONUS_THRESHOLD = 2;
  private static final Double INTERMEDIATE_BONUS = 1.4;
  private static final Double LAST_PROMOTION_PENALTY = 0.8;

  /**
   * Constructor for class FullTimeEmployee
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
   */
  public FullTimeEmployee(String employeeID, ContactInfo contactInfo, LocalDate employmentDate,
      EmploymentLevel employmentLevel, Double lastYearsEarnings, Double basePay, Double bonuses,
      Double overtime, LocalDate lastPromotionDate, Integer numProjects) {
    super(employeeID, contactInfo, employmentDate, employmentLevel, lastYearsEarnings);
    this.basePay = basePay;
    this.bonuses = bonuses;
    this.overtime = overtime;
    this.lastPromotionDate = lastPromotionDate;
    this.numProjects = numProjects;
  }

  /**
   * Helper method for estimateProductivity()
   *
   * @return - double, base productivity score
   */
  protected double baseProductivity() {
    double productivity = super.lastYearsEarnings / this.basePay;

    if (numProjects > NUM_PROJECTS_BONUS_THRESHOLD) {
      productivity += NUM_PROJECTS_BONUS;
    }
    if (employmentLevel == EmploymentLevel.INTERMEDIATE_LEVEL) {
      productivity += INTERMEDIATE_BONUS;
    }
    if (lastPromotionDate.isBefore(LocalDate.now().minusYears(3))) {
      productivity -= LAST_PROMOTION_PENALTY;
    }
    return productivity;
  }

  /**
   * @return - Double, gives employee's base pay
   */
  public Double getBasePay() {
    return basePay;
  }

  /**
   * @return - Double, gives employee's bonuses
   */
  public Double getBonuses() {
    return bonuses;
  }

  /**
   * @return - Double, gives employee's overtime
   */
  public Double getOvertime() {
    return overtime;
  }

  /**
   * @return - LocalDate, gives employee's last promotion date
   */
  public LocalDate getLastPromotionDate() {
    return lastPromotionDate;
  }

  /**
   * @return - Integer, gives employee's number of projects
   */
  public Integer getNumProjects() {
    return numProjects;
  }
}
