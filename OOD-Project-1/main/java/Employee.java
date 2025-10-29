import java.time.LocalDate;

/**
 * Class Employee stores information for a given employee
 */
public abstract class Employee {

  protected String employeeID;
  protected ContactInfo contactInfo;
  protected LocalDate employmentDate;
  protected EmploymentLevel employmentLevel;
  protected Double lastYearsEarnings;

  /**
   * Constructor for class Employee
   *
   * @param employeeID        - String, representing employee's ID
   * @param contactInfo       - ContactInfo, representing employee's contact info
   * @param employmentDate    - LocalDate, representing the day the employee started working
   * @param employmentLevel   - EmploymentLevel, representing employee's level
   * @param lastYearsEarnings - Double, representing employee's earnings last year
   */
  public Employee(String employeeID, ContactInfo contactInfo, LocalDate employmentDate,
      EmploymentLevel employmentLevel, Double lastYearsEarnings) {
    this.employeeID = employeeID;
    this.contactInfo = contactInfo;
    this.employmentDate = employmentDate;
    this.employmentLevel = employmentLevel;
    this.lastYearsEarnings = lastYearsEarnings;
  }

  /**
   * @return - Double, estimates employee's productivity
   */
  public abstract Double estimateProductivity();

  /**
   * @return - String, gives employee's ID
   */
  public String getEmployeeID() {
    return employeeID;
  }

  /**
   * @return - ContactInfo, gives employee's contact info
   */
  public ContactInfo getContactInfo() {
    return contactInfo;
  }

  /**
   * @return - LocalDate, gives employee's employment date
   */
  public LocalDate getEmploymentDate() {
    return employmentDate;
  }

  /**
   * @return - EmploymentLevel, gives employee's level
   */
  public EmploymentLevel getEmploymentLevel() {
    return employmentLevel;
  }

  /**
   * @return - Double, gives employee's earnings last year
   */
  public Double getLastYearsEarnings() {
    return lastYearsEarnings;
  }
}
